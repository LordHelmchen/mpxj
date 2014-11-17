/*
 * file:       PrimaveraPMFileWriter.java
 * author:     Jon Iles
 * copyright:  (c) Packwood Software 2012
 * date:       2012-03-16
 */

/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package net.sf.mpxj.primavera;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.mpxj.ConstraintType;
import net.sf.mpxj.DateRange;
import net.sf.mpxj.Day;
import net.sf.mpxj.Duration;
import net.sf.mpxj.ProjectCalendar;
import net.sf.mpxj.ProjectCalendarException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.ProjectHeader;
import net.sf.mpxj.Relation;
import net.sf.mpxj.RelationType;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.TimeUnit;
import net.sf.mpxj.primavera.schema.APIBusinessObjects;
import net.sf.mpxj.primavera.schema.ActivityType;
import net.sf.mpxj.primavera.schema.CalendarType;
import net.sf.mpxj.primavera.schema.CalendarType.HolidayOrExceptions;
import net.sf.mpxj.primavera.schema.CalendarType.HolidayOrExceptions.HolidayOrException;
import net.sf.mpxj.primavera.schema.CalendarType.StandardWorkWeek;
import net.sf.mpxj.primavera.schema.CalendarType.StandardWorkWeek.StandardWorkHours;
import net.sf.mpxj.primavera.schema.ObjectFactory;
import net.sf.mpxj.primavera.schema.ProjectType;
import net.sf.mpxj.primavera.schema.RelationshipType;
import net.sf.mpxj.primavera.schema.ResourceAssignmentType;
import net.sf.mpxj.primavera.schema.ResourceType;
import net.sf.mpxj.primavera.schema.WBSType;
import net.sf.mpxj.primavera.schema.WorkTimeType;
import net.sf.mpxj.utility.NumberHelper;
import net.sf.mpxj.writer.AbstractProjectWriter;

/**
 * This class creates a new MSPDI file from the contents of an ProjectFile
 * instance.
 */
public final class PrimaveraPMFileWriter extends AbstractProjectWriter
{
   /**
    * {@inheritDoc}
    */
   @Override public void write(ProjectFile projectFile, OutputStream stream) throws IOException
   {
      try
      {
         if (CONTEXT == null)
         {
            throw CONTEXT_EXCEPTION;
         }

         //
         // The Primavera schema defines elements as nillable, which by
         // default results in
         // JAXB generating elements like this <element xsl:nil="true"/>
         // whereas Primavera itself simply omits these elements.
         //
         // The XSLT stylesheet below transforms the XML generated by JAXB on
         // the fly to remove any nil elements.
         //
         TransformerFactory transFact = TransformerFactory.newInstance();
         TransformerHandler handler = ((SAXTransformerFactory) transFact).newTransformerHandler(new StreamSource(new ByteArrayInputStream(NILLABLE_STYLESHEET.getBytes())));
         handler.setResult(new StreamResult(stream));
         Transformer transformer = handler.getTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

         m_projectFile = projectFile;
         m_calendar = Calendar.getInstance();

         Marshaller marshaller = CONTEXT.createMarshaller();

         marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");

         m_factory = new ObjectFactory();
         m_apibo = m_factory.createAPIBusinessObjects();

         writeProjectHeader();
         writeCalendars();
         writeResources();
         writeTasks();
         writeAssignments();

         DatatypeConverter.setParentFile(m_projectFile);

         marshaller.marshal(m_apibo, handler);
      }

      catch (JAXBException ex)
      {
         throw new IOException(ex.toString());
      }

      catch (TransformerConfigurationException ex)
      {
         throw new IOException(ex.toString());
      }

      finally
      {
         m_projectFile = null;
         m_factory = null;
         m_apibo = null;
         m_project = null;
         m_wbsSequence = 0;
         m_relationshipObjectID = 0;
         m_calendar = null;
      }
   }

   /**
    * This method writes project header data to a PM XML file.
    */
   private void writeProjectHeader()
   {
      m_project = m_factory.createProjectType();
      m_apibo.getProject().add(m_project);

      ProjectHeader mpxj = m_projectFile.getProjectHeader();
      Task rootTask = m_projectFile.getTaskByUniqueID(Integer.valueOf(0));
      UUID guid = rootTask == null ? null : rootTask.getGUID();

      m_project.setActivityDefaultActivityType("Task Dependent");
      m_project.setActivityDefaultCalendarObjectId(getCalendarUniqueID(m_projectFile.getCalendar()));
      m_project.setActivityDefaultDurationType("Fixed Duration and Units");
      m_project.setActivityDefaultPercentCompleteType("Duration");
      m_project.setActivityDefaultPricePerUnit(NumberHelper.DOUBLE_ZERO);
      m_project.setActivityIdBasedOnSelectedActivity(Boolean.TRUE);
      m_project.setActivityIdIncrement(Integer.valueOf(10));
      m_project.setActivityIdPrefix("A");
      m_project.setActivityIdSuffix(Integer.valueOf(1000));
      m_project.setActivityPercentCompleteBasedOnActivitySteps(Boolean.FALSE);
      m_project.setAddActualToRemaining(Boolean.FALSE);
      m_project.setAllowNegativeActualUnitsFlag(Boolean.FALSE);
      m_project.setAssignmentDefaultDrivingFlag(Boolean.TRUE);
      m_project.setAssignmentDefaultRateType("Price / Unit");
      m_project.setCheckOutStatus(Boolean.FALSE);
      m_project.setCostQuantityRecalculateFlag(Boolean.FALSE);
      m_project.setCreateDate(mpxj.getCreationDate());
      m_project.setCriticalActivityFloatLimit(NumberHelper.DOUBLE_ZERO);
      m_project.setCriticalActivityPathType("Critical Float");
      m_project.setDefaultPriceTimeUnits("Hour");
      m_project.setDiscountApplicationPeriod("Month");
      m_project.setEarnedValueComputeType("Activity Percent Complete");
      m_project.setEarnedValueETCComputeType("ETC = Remaining Cost for Activity");
      m_project.setEarnedValueETCUserValue(Double.valueOf(0.88));
      m_project.setEarnedValueUserPercent(Double.valueOf(0.06));
      m_project.setEnableSummarization(Boolean.TRUE);
      m_project.setFiscalYearStartMonth(Integer.valueOf(1));
      m_project.setFinishDate(mpxj.getFinishDate());
      m_project.setGUID(getGUID(guid));
      m_project.setId(PROJECT_ID);
      m_project.setLastUpdateDate(mpxj.getLastSaved());
      m_project.setLevelingPriority(Integer.valueOf(10));
      m_project.setLinkActualToActualThisPeriod(Boolean.TRUE);
      m_project.setLinkPercentCompleteWithActual(Boolean.TRUE);
      m_project.setLinkPlannedAndAtCompletionFlag(Boolean.TRUE);
      m_project.setName(mpxj.getName() == null ? PROJECT_ID : mpxj.getName());
      m_project.setObjectId(PROJECT_OBJECT_ID);
      m_project.setPlannedStartDate(mpxj.getStartDate());
      m_project.setPrimaryResourcesCanMarkActivitiesAsCompleted(Boolean.TRUE);
      m_project.setResetPlannedToRemainingFlag(Boolean.FALSE);
      m_project.setResourceCanBeAssignedToSameActivityMoreThanOnce(Boolean.TRUE);
      m_project.setResourcesCanAssignThemselvesToActivities(Boolean.TRUE);
      m_project.setResourcesCanEditAssignmentPercentComplete(Boolean.FALSE);
      m_project.setResourcesCanMarkAssignmentAsCompleted(Boolean.FALSE);
      m_project.setResourcesCanViewInactiveActivities(Boolean.FALSE);
      m_project.setRiskLevel("Medium");
      m_project.setStartDate(mpxj.getStartDate());
      m_project.setStatus("Active");
      m_project.setStrategicPriority(Integer.valueOf(500));
      m_project.setSummarizeToWBSLevel(Integer.valueOf(2));
      m_project.setSummaryLevel("Assignment Level");
      m_project.setUseProjectBaselineForEarnedValue(Boolean.TRUE);
      m_project.setWBSCodeSeparator(".");
   }

   /**
    * This method writes calendar data to a PM XML file. 
    */
   private void writeCalendars()
   {
      for (ProjectCalendar calendar : m_projectFile.getCalendars())
      {
         writeCalendar(calendar);
      }
   }

   /**
    * This method writes data for an individual calendar to a PM XML file.
    * 
    * @param mpxj ProjectCalander instance
    */
   private void writeCalendar(ProjectCalendar mpxj)
   {
      CalendarType xml = m_factory.createCalendarType();
      m_apibo.getCalendar().add(xml);
      String type = mpxj.getResource() == null ? "Global" : "Resource";

      xml.setBaseCalendarObjectId(getCalendarUniqueID(mpxj.getParent()));
      xml.setIsPersonal(mpxj.getResource() == null ? Boolean.FALSE : Boolean.TRUE);
      xml.setName(mpxj.getName());
      xml.setObjectId(mpxj.getUniqueID());
      xml.setType(type);

      StandardWorkWeek xmlStandardWorkWeek = m_factory.createCalendarTypeStandardWorkWeek();
      xml.setStandardWorkWeek(xmlStandardWorkWeek);

      for (Day day : EnumSet.allOf(Day.class))
      {
         StandardWorkHours xmlHours = m_factory.createCalendarTypeStandardWorkWeekStandardWorkHours();
         xmlStandardWorkWeek.getStandardWorkHours().add(xmlHours);
         xmlHours.setDayOfWeek(getDayName(day));

         for (DateRange range : mpxj.getHours(day))
         {
            WorkTimeType xmlWorkTime = m_factory.createWorkTimeType();
            xmlHours.getWorkTime().add(xmlWorkTime);

            xmlWorkTime.setStart(range.getStart());
            xmlWorkTime.setFinish(getEndTime(range.getEnd()));
         }
      }

      HolidayOrExceptions xmlExceptions = m_factory.createCalendarTypeHolidayOrExceptions();
      xml.setHolidayOrExceptions(xmlExceptions);

      for (ProjectCalendarException mpxjException : mpxj.getCalendarExceptions())
      {
         m_calendar.setTime(mpxjException.getFromDate());
         while (m_calendar.getTimeInMillis() < mpxjException.getToDate().getTime())
         {
            HolidayOrException xmlException = m_factory.createCalendarTypeHolidayOrExceptionsHolidayOrException();
            xmlExceptions.getHolidayOrException().add(xmlException);

            xmlException.setDate(m_calendar.getTime());

            for (DateRange range : mpxjException)
            {
               WorkTimeType xmlHours = m_factory.createWorkTimeType();
               xmlException.getWorkTime().add(xmlHours);

               xmlHours.setStart(range.getStart());
               xmlHours.setFinish(getEndTime(range.getEnd()));
            }
            m_calendar.add(Calendar.DAY_OF_YEAR, 1);
         }
      }
   }

   /**
    * This method writes resource data to a PM XML file. 
    */
   private void writeResources()
   {
      for (Resource resource : m_projectFile.getAllResources())
      {
         if (resource.getUniqueID().intValue() != 0)
         {
            writeResource(resource);
         }
      }
   }

   /**
    * Write a single resource.
    * 
    * @param mpxj Resource instance
    */
   private void writeResource(Resource mpxj)
   {
      ResourceType xml = m_factory.createResourceType();
      m_apibo.getResource().add(xml);

      xml.setAutoComputeActuals(Boolean.TRUE);
      xml.setCalculateCostFromUnits(Boolean.TRUE);
      xml.setCalendarObjectId(getCalendarUniqueID(mpxj.getResourceCalendar()));
      xml.setDefaultUnitsPerTime(Double.valueOf(1.0));
      xml.setEmailAddress(mpxj.getEmailAddress());
      xml.setGUID(getGUID(mpxj.getGUID()));
      xml.setId(RESOURCE_ID_PREFIX + mpxj.getUniqueID());
      xml.setIsActive(Boolean.TRUE);
      xml.setMaxUnitsPerTime(getPercentage(mpxj.getMaxUnits()));
      xml.setName(mpxj.getName());
      xml.setObjectId(mpxj.getUniqueID());
      xml.setResourceNotes(mpxj.getNotes());
      xml.setResourceType(getResourceType(mpxj));
   }

   /**
    * This method writes task data to a PM XML file.
    * 
    */
   private void writeTasks()
   {
      for (Task task : m_projectFile.getChildTasks())
      {
         writeTask(task);
      }
   }

   /**
    * Used to write the child tasks of a parent task to the PM XML file.
    * 
    * @param parent parent Task instance
    */
   private void writeChildTasks(Task parent)
   {
      for (Task task : parent.getChildTasks())
      {
         writeTask(task);
      }
   }

   /**
    * Given a Task instance, this task determines if it should be written to the 
    * PM XML file as an activity or as a WBS item, and calls the appropriate
    * method.
    * 
    * @param task Task instance
    */
   private void writeTask(Task task)
   {
      if (!task.getNull())
      {
         if (task.getSummary())
         {
            writeWBS(task);
         }
         else
         {
            writeActivity(task);
         }
      }
   }

   /**
    * Writes a WBS entity to the PM XML file.
    * 
    * @param mpxj MPXJ Task entity
    */
   private void writeWBS(Task mpxj)
   {
      if (mpxj.getUniqueID().intValue() != 0)
      {
         WBSType xml = m_factory.createWBSType();
         m_project.getWBS().add(xml);
         String code = mpxj.getWBS();
         code = code == null || code.length() == 0 ? DEFAULT_WBS_CODE : code;

         Task parentTask = mpxj.getParentTask();
         Integer parentObjectID = parentTask == null ? null : parentTask.getUniqueID();

         xml.setCode(code);
         xml.setGUID(getGUID(mpxj.getGUID()));
         xml.setName(mpxj.getName());

         xml.setObjectId(mpxj.getUniqueID());
         xml.setParentObjectId(parentObjectID);
         xml.setProjectObjectId(PROJECT_OBJECT_ID);
         xml.setSequenceNumber(Integer.valueOf(m_wbsSequence++));

         xml.setStatus("Active");
      }

      writeChildTasks(mpxj);
   }

   /**
    * Writes an activity to a PM XML file.
    * 
    * @param mpxj MPXJ Task instance
    */
   private void writeActivity(Task mpxj)
   {
      ActivityType xml = m_factory.createActivityType();
      m_project.getActivity().add(xml);

      Task parentTask = mpxj.getParentTask();
      Integer parentObjectID = parentTask == null ? null : parentTask.getUniqueID();

      xml.setActualStartDate(mpxj.getActualStart());
      xml.setActualFinishDate(mpxj.getActualFinish());
      xml.setAtCompletionDuration(getDuration(mpxj.getDuration()));
      xml.setCalendarObjectId(getCalendarUniqueID(mpxj.getCalendar()));
      xml.setDurationPercentComplete(getPercentage(mpxj.getPercentageComplete()));
      xml.setDurationType("Fixed Units/Time");
      xml.setFinishDate(mpxj.getFinish());
      xml.setGUID(getGUID(mpxj.getGUID()));
      xml.setId(mpxj.getWBS());
      xml.setName(mpxj.getName());
      xml.setObjectId(mpxj.getUniqueID());
      xml.setPrimaryConstraintType(CONSTRAINT_TYPE_MAP.get(mpxj.getConstraintType()));
      xml.setPrimaryConstraintDate(mpxj.getConstraintDate());
      xml.setPlannedDuration(getDuration(mpxj.getDuration()));
      xml.setPlannedFinishDate(mpxj.getFinish());
      xml.setPlannedStartDate(mpxj.getStart());
      xml.setProjectObjectId(PROJECT_OBJECT_ID);
      xml.setRemainingDuration(getDuration(mpxj.getRemainingDuration()));
      xml.setRemainingEarlyFinishDate(mpxj.getEarlyFinish());
      xml.setRemainingEarlyStartDate(mpxj.getResume());
      xml.setRemainingLaborCost(NumberHelper.DOUBLE_ZERO);
      xml.setRemainingLaborUnits(NumberHelper.DOUBLE_ZERO);
      xml.setRemainingNonLaborCost(NumberHelper.DOUBLE_ZERO);
      xml.setRemainingNonLaborUnits(NumberHelper.DOUBLE_ZERO);
      xml.setStartDate(mpxj.getStart());
      xml.setStatus(getActivityStatus(mpxj));
      xml.setType("Resource Dependent");
      xml.setWBSObjectId(parentObjectID);

      writePredecessors(mpxj);
   }

   /**
    * Writes assignment data to a PM XML file. 
    */
   private void writeAssignments()
   {
      for (ResourceAssignment assignment : m_projectFile.getAllResourceAssignments())
      {
         Resource resource = assignment.getResource();
         if (resource != null)
         {
            Task task = assignment.getTask();
            if (task != null && task.getUniqueID().intValue() != 0 && !task.getSummary())
            {
               writeAssignment(assignment);
            }
         }
      }
   }

   /**
    * Writes a resource assignment to a PM XML file.
    * 
    * @param mpxj MPXJ ResourceAssignment instance
    */
   private void writeAssignment(ResourceAssignment mpxj)
   {
      ResourceAssignmentType xml = m_factory.createResourceAssignmentType();
      m_project.getResourceAssignment().add(xml);
      Task task = mpxj.getTask();
      Task parentTask = task.getParentTask();
      Integer parentTaskUniqueID = parentTask == null ? null : parentTask.getUniqueID();

      xml.setActivityObjectId(mpxj.getTaskUniqueID());
      xml.setActualFinishDate(mpxj.getActualFinish());
      xml.setActualRegularUnits(getDuration(mpxj.getActualWork()));
      xml.setActualStartDate(mpxj.getActualStart());
      xml.setActualUnits(getDuration(mpxj.getActualWork()));
      xml.setAtCompletionUnits(getDuration(mpxj.getRemainingWork()));
      xml.setFinishDate(mpxj.getFinish());
      xml.setGUID(getGUID(mpxj.getGUID()));
      xml.setObjectId(mpxj.getUniqueID());
      xml.setPlannedDuration(getDuration(mpxj.getWork()));
      xml.setPlannedFinishDate(mpxj.getFinish());
      xml.setPlannedStartDate(mpxj.getStart());
      xml.setPlannedUnits(getDuration(mpxj.getWork()));
      xml.setPlannedUnitsPerTime(getPercentage(mpxj.getUnits()));
      xml.setProjectObjectId(PROJECT_OBJECT_ID);
      xml.setRemainingDuration(getDuration(mpxj.getRemainingWork()));
      xml.setRemainingFinishDate(mpxj.getFinish());
      xml.setRemainingStartDate(mpxj.getStart());
      xml.setRemainingUnits(getDuration(mpxj.getRemainingWork()));
      xml.setRemainingUnitsPerTime(getPercentage(mpxj.getUnits()));
      xml.setResourceObjectId(mpxj.getResourceUniqueID());
      xml.setStartDate(mpxj.getStart());
      xml.setWBSObjectId(parentTaskUniqueID);
   }

   /**
    * Writes task predecessor links to a PM XML file.
    * 
    * @param task MPXJ Task instance
    */
   private void writePredecessors(Task task)
   {
      List<Relation> relations = task.getPredecessors();
      if (relations != null)
      {
         for (Relation mpxj : relations)
         {
            RelationshipType xml = m_factory.createRelationshipType();
            m_project.getRelationship().add(xml);

            xml.setLag(getDuration(mpxj.getLag()));
            xml.setObjectId(Integer.valueOf(++m_relationshipObjectID));
            xml.setPredecessorActivityObjectId(mpxj.getTargetTask().getUniqueID());
            xml.setSuccessorActivityObjectId(mpxj.getSourceTask().getUniqueID());
            xml.setPredecessorProjectObjectId(PROJECT_OBJECT_ID);
            xml.setSuccessorProjectObjectId(PROJECT_OBJECT_ID);
            xml.setType(RELATION_TYPE_MAP.get(mpxj.getType()));
         }
      }
   }

   /**
    * Retrieve a duration in the form required by Primavera. 
    * 
    * @param duration Duration instance
    * @return formatted duration
    */
   private Double getDuration(Duration duration)
   {
      if (duration.getUnits() != TimeUnit.HOURS)
      {
         duration = duration.convertUnits(TimeUnit.HOURS, m_projectFile.getProjectHeader());
      }

      return Double.valueOf(duration.getDuration());
   }

   /**
    * Retrieve a GUID in the form required by Primavera.
    * 
    * @param guid UUID instance
    * @return formatted GUID
    */
   private String getGUID(UUID guid)
   {
      return guid == null ? null : "{" + guid.toString().toUpperCase() + "}";
   }

   /**
    * Formats a day name.
    * 
    * @param day MPXJ Day instance
    * @return Primavera day instance
    */
   private String getDayName(Day day)
   {
      return DAY_NAMES[day.getValue() - 1];
   }

   /**
    * Formats a resource type.
    * 
    * @param resource MPXJ resource
    * @return Primavera resource type
    */
   private String getResourceType(Resource resource)
   {
      String result;

      switch (resource.getType())
      {
         case MATERIAL:
         {
            result = "Material";
            break;
         }

         case COST:
         {
            result = "Nonlabor";
            break;
         }

         default:
         {
            result = "Labor";
            break;
         }
      }

      return result;
   }

   /**
    * Formats a percentage value.
    * 
    * @param number MPXJ percentage value
    * @return Primavera percentage value
    */
   private Double getPercentage(Number number)
   {
      Double result = null;

      if (number != null)
      {
         result = Double.valueOf(number.doubleValue() / 100);
      }

      return result;
   }

   /**
    * The end of a Primavera time range finishes on the last minute
    * of the period, so a range of 12:00 -> 13:00 is represented by
    * Primavera as 12:00 -> 12:59.
    * 
    * @param date MPXJ end time
    * @return Primavera end time
    */
   private Date getEndTime(Date date)
   {
      m_calendar.setTime(date);
      m_calendar.add(Calendar.MINUTE, -1);
      return m_calendar.getTime();
   }

   /**
    * Retrieve a calendar unique ID.
    * 
    * @param calendar ProjectCalendar instance
    * @return calendar unique ID
    */
   private Integer getCalendarUniqueID(ProjectCalendar calendar)
   {
      return calendar == null ? null : calendar.getUniqueID();
   }

   /**
    * Retrieve an activity status.
    * 
    * @param mpxj MPXJ Task instance
    * @return activity status
    */
   private String getActivityStatus(Task mpxj)
   {
      String result;
      if (mpxj.getActualStart() == null)
      {
         result = "Not Started";
      }
      else
      {
         if (mpxj.getActualFinish() == null)
         {
            result = "In Progress";
         }
         else
         {
            result = "Completed";
         }
      }
      return result;
   }

   /**
    * Package-private accessor method used to retrieve the project file
    * currently being processed by this writer.
    * 
    * @return project file instance
    */
   ProjectFile getProjectFile()
   {
      return (m_projectFile);
   }

   /**
    * Cached context to minimise construction cost.
    */
   private static JAXBContext CONTEXT;

   /**
    * Note any error occurring during context construction.
    */
   private static JAXBException CONTEXT_EXCEPTION;

   static
   {
      try
      {
         //
         // JAXB RI property to speed up construction
         //
         System.setProperty("com.sun.xml.bind.v2.runtime.JAXBContextImpl.fastBoot", "true");

         //
         // Construct the context
         //
         CONTEXT = JAXBContext.newInstance("net.sf.mpxj.primavera.schema", PrimaveraPMFileWriter.class.getClassLoader());
      }

      catch (JAXBException ex)
      {
         CONTEXT_EXCEPTION = ex;
         CONTEXT = null;
      }
   }

   private static final String NILLABLE_STYLESHEET = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><xsl:output method=\"xml\" indent=\"yes\"/><xsl:template match=\"node()[not(@xsi:nil = 'true')]|@*\"><xsl:copy><xsl:apply-templates select=\"node()|@*\"/></xsl:copy></xsl:template></xsl:stylesheet>";
   private static final Integer PROJECT_OBJECT_ID = Integer.valueOf(1);
   private static final String PROJECT_ID = "PROJECT";
   private static final String RESOURCE_ID_PREFIX = "RESOURCE-";
   private static final String DEFAULT_WBS_CODE = "WBS";

   private static final String[] DAY_NAMES =
   {
      "Sunday",
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday"
   };

   private static final Map<RelationType, String> RELATION_TYPE_MAP = new HashMap<RelationType, String>();
   static
   {
      RELATION_TYPE_MAP.put(RelationType.FINISH_START, "Finish to Start");
      RELATION_TYPE_MAP.put(RelationType.FINISH_FINISH, "Finish to Finish");
      RELATION_TYPE_MAP.put(RelationType.START_START, "Start to Start");
      RELATION_TYPE_MAP.put(RelationType.START_FINISH, "Start to Finish");
   }

   private static final Map<ConstraintType, String> CONSTRAINT_TYPE_MAP = new HashMap<ConstraintType, String>();
   static
   {
      CONSTRAINT_TYPE_MAP.put(ConstraintType.START_NO_LATER_THAN, "Start On or Before");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.START_NO_EARLIER_THAN, "Start On or After");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.MUST_FINISH_ON, "Finish On");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.FINISH_NO_LATER_THAN, "Finish On or Before");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.FINISH_NO_EARLIER_THAN, "Finish On or After");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.AS_LATE_AS_POSSIBLE, "As Late As Possible");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.MUST_START_ON, "Mandatory Start");
      CONSTRAINT_TYPE_MAP.put(ConstraintType.MUST_FINISH_ON, "Mandatory Finish");
   }

   private ProjectFile m_projectFile;
   private ObjectFactory m_factory;
   private APIBusinessObjects m_apibo;
   private ProjectType m_project;
   private int m_wbsSequence;
   private int m_relationshipObjectID;
   private Calendar m_calendar;
}
