//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.01.12 at 08:36:06 AM GMT
//

package net.sf.mpxj.primavera.schema;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * &lt;p&gt;Java class for ResourceHourType complex type.
 *
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="ResourceHourType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ActivityObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ActivityTimesheetLinkFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ApprovedHours" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ApprovedOvertimeHours" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CreateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CreateUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsBaseline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsTemplate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LastUpdateUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="OverheadCodeName" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="32"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="OverheadCodeObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ProjectId" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="40"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="ProjectName" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="100"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="ProjectObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ResourceAssignmentObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ResourceId" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="255"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="ResourceIntegratedType" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;enumeration value=""/&amp;gt;
 *               &amp;lt;enumeration value="ERP"/&amp;gt;
 *               &amp;lt;enumeration value="Gateway"/&amp;gt;
 *               &amp;lt;enumeration value="PrimaveraCloudScope"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="ResourceName" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="255"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="ResourceObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Status" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;enumeration value=""/&amp;gt;
 *               &amp;lt;enumeration value="Submitted"/&amp;gt;
 *               &amp;lt;enumeration value="Approved"/&amp;gt;
 *               &amp;lt;enumeration value="Resource Manager Approved"/&amp;gt;
 *               &amp;lt;enumeration value="Project Manager Approved"/&amp;gt;
 *               &amp;lt;enumeration value="Active"/&amp;gt;
 *               &amp;lt;enumeration value="Rejected"/&amp;gt;
 *               &amp;lt;enumeration value="Resubmitted"/&amp;gt;
 *               &amp;lt;enumeration value="Reopened"/&amp;gt;
 *               &amp;lt;enumeration value="Submitted for RM"/&amp;gt;
 *               &amp;lt;enumeration value="Resubmitted for RM"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="TimesheetPeriodObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="TimesheetStatusDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="UnapprovedHours" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="UnapprovedOvertimeHours" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="WBSObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "ResourceHourType", propOrder =
{
   "activityObjectId",
   "activityTimesheetLinkFlag",
   "approvedHours",
   "approvedOvertimeHours",
   "createDate",
   "createUser",
   "date",
   "isBaseline",
   "isTemplate",
   "lastUpdateDate",
   "lastUpdateUser",
   "objectId",
   "overheadCodeName",
   "overheadCodeObjectId",
   "projectId",
   "projectName",
   "projectObjectId",
   "resourceAssignmentObjectId",
   "resourceId",
   "resourceIntegratedType",
   "resourceName",
   "resourceObjectId",
   "status",
   "timesheetPeriodObjectId",
   "timesheetStatusDate",
   "unapprovedHours",
   "unapprovedOvertimeHours",
   "wbsObjectId"
}) public class ResourceHourType
{

   @XmlElement(name = "ActivityObjectId", nillable = true) protected Integer activityObjectId;
   @XmlElement(name = "ActivityTimesheetLinkFlag", type = String.class) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "boolean") protected Boolean activityTimesheetLinkFlag;
   @XmlElement(name = "ApprovedHours", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter2.class) @XmlSchemaType(name = "double") protected Double approvedHours;
   @XmlElement(name = "ApprovedOvertimeHours", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter2.class) @XmlSchemaType(name = "double") protected Double approvedOvertimeHours;
   @XmlElement(name = "CreateDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter3.class) @XmlSchemaType(name = "dateTime") protected Date createDate;
   @XmlElement(name = "CreateUser") protected String createUser;
   @XmlElement(name = "Date", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter3.class) @XmlSchemaType(name = "dateTime") protected Date date;
   @XmlElement(name = "IsBaseline", type = String.class) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "boolean") protected Boolean isBaseline;
   @XmlElement(name = "IsTemplate", type = String.class) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "boolean") protected Boolean isTemplate;
   @XmlElement(name = "LastUpdateDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter3.class) @XmlSchemaType(name = "dateTime") protected Date lastUpdateDate;
   @XmlElement(name = "LastUpdateUser") protected String lastUpdateUser;
   @XmlElement(name = "ObjectId") protected Integer objectId;
   @XmlElement(name = "OverheadCodeName") protected String overheadCodeName;
   @XmlElement(name = "OverheadCodeObjectId", nillable = true) protected Integer overheadCodeObjectId;
   @XmlElement(name = "ProjectId") protected String projectId;
   @XmlElement(name = "ProjectName") protected String projectName;
   @XmlElement(name = "ProjectObjectId", nillable = true) protected Integer projectObjectId;
   @XmlElement(name = "ResourceAssignmentObjectId", nillable = true) protected Integer resourceAssignmentObjectId;
   @XmlElement(name = "ResourceId") protected String resourceId;
   @XmlElement(name = "ResourceIntegratedType") protected String resourceIntegratedType;
   @XmlElement(name = "ResourceName") protected String resourceName;
   @XmlElement(name = "ResourceObjectId") protected Integer resourceObjectId;
   @XmlElement(name = "Status") protected String status;
   @XmlElement(name = "TimesheetPeriodObjectId") protected Integer timesheetPeriodObjectId;
   @XmlElement(name = "TimesheetStatusDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter3.class) @XmlSchemaType(name = "dateTime") protected Date timesheetStatusDate;
   @XmlElement(name = "UnapprovedHours", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter2.class) @XmlSchemaType(name = "double") protected Double unapprovedHours;
   @XmlElement(name = "UnapprovedOvertimeHours", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter2.class) @XmlSchemaType(name = "double") protected Double unapprovedOvertimeHours;
   @XmlElement(name = "WBSObjectId", nillable = true) protected Integer wbsObjectId;

   /**
    * Gets the value of the activityObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getActivityObjectId()
   {
      return activityObjectId;
   }

   /**
    * Sets the value of the activityObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setActivityObjectId(Integer value)
   {
      this.activityObjectId = value;
   }

   /**
    * Gets the value of the activityTimesheetLinkFlag property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Boolean isActivityTimesheetLinkFlag()
   {
      return activityTimesheetLinkFlag;
   }

   /**
    * Sets the value of the activityTimesheetLinkFlag property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setActivityTimesheetLinkFlag(Boolean value)
   {
      this.activityTimesheetLinkFlag = value;
   }

   /**
    * Gets the value of the approvedHours property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Double getApprovedHours()
   {
      return approvedHours;
   }

   /**
    * Sets the value of the approvedHours property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setApprovedHours(Double value)
   {
      this.approvedHours = value;
   }

   /**
    * Gets the value of the approvedOvertimeHours property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Double getApprovedOvertimeHours()
   {
      return approvedOvertimeHours;
   }

   /**
    * Sets the value of the approvedOvertimeHours property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setApprovedOvertimeHours(Double value)
   {
      this.approvedOvertimeHours = value;
   }

   /**
    * Gets the value of the createDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getCreateDate()
   {
      return createDate;
   }

   /**
    * Sets the value of the createDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setCreateDate(Date value)
   {
      this.createDate = value;
   }

   /**
    * Gets the value of the createUser property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getCreateUser()
   {
      return createUser;
   }

   /**
    * Sets the value of the createUser property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setCreateUser(String value)
   {
      this.createUser = value;
   }

   /**
    * Gets the value of the date property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getDate()
   {
      return date;
   }

   /**
    * Sets the value of the date property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setDate(Date value)
   {
      this.date = value;
   }

   /**
    * Gets the value of the isBaseline property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Boolean isIsBaseline()
   {
      return isBaseline;
   }

   /**
    * Sets the value of the isBaseline property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setIsBaseline(Boolean value)
   {
      this.isBaseline = value;
   }

   /**
    * Gets the value of the isTemplate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Boolean isIsTemplate()
   {
      return isTemplate;
   }

   /**
    * Sets the value of the isTemplate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setIsTemplate(Boolean value)
   {
      this.isTemplate = value;
   }

   /**
    * Gets the value of the lastUpdateDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getLastUpdateDate()
   {
      return lastUpdateDate;
   }

   /**
    * Sets the value of the lastUpdateDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setLastUpdateDate(Date value)
   {
      this.lastUpdateDate = value;
   }

   /**
    * Gets the value of the lastUpdateUser property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getLastUpdateUser()
   {
      return lastUpdateUser;
   }

   /**
    * Sets the value of the lastUpdateUser property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setLastUpdateUser(String value)
   {
      this.lastUpdateUser = value;
   }

   /**
    * Gets the value of the objectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getObjectId()
   {
      return objectId;
   }

   /**
    * Sets the value of the objectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setObjectId(Integer value)
   {
      this.objectId = value;
   }

   /**
    * Gets the value of the overheadCodeName property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getOverheadCodeName()
   {
      return overheadCodeName;
   }

   /**
    * Sets the value of the overheadCodeName property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setOverheadCodeName(String value)
   {
      this.overheadCodeName = value;
   }

   /**
    * Gets the value of the overheadCodeObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getOverheadCodeObjectId()
   {
      return overheadCodeObjectId;
   }

   /**
    * Sets the value of the overheadCodeObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setOverheadCodeObjectId(Integer value)
   {
      this.overheadCodeObjectId = value;
   }

   /**
    * Gets the value of the projectId property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getProjectId()
   {
      return projectId;
   }

   /**
    * Sets the value of the projectId property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setProjectId(String value)
   {
      this.projectId = value;
   }

   /**
    * Gets the value of the projectName property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getProjectName()
   {
      return projectName;
   }

   /**
    * Sets the value of the projectName property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setProjectName(String value)
   {
      this.projectName = value;
   }

   /**
    * Gets the value of the projectObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getProjectObjectId()
   {
      return projectObjectId;
   }

   /**
    * Sets the value of the projectObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setProjectObjectId(Integer value)
   {
      this.projectObjectId = value;
   }

   /**
    * Gets the value of the resourceAssignmentObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getResourceAssignmentObjectId()
   {
      return resourceAssignmentObjectId;
   }

   /**
    * Sets the value of the resourceAssignmentObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setResourceAssignmentObjectId(Integer value)
   {
      this.resourceAssignmentObjectId = value;
   }

   /**
    * Gets the value of the resourceId property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getResourceId()
   {
      return resourceId;
   }

   /**
    * Sets the value of the resourceId property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setResourceId(String value)
   {
      this.resourceId = value;
   }

   /**
    * Gets the value of the resourceIntegratedType property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getResourceIntegratedType()
   {
      return resourceIntegratedType;
   }

   /**
    * Sets the value of the resourceIntegratedType property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setResourceIntegratedType(String value)
   {
      this.resourceIntegratedType = value;
   }

   /**
    * Gets the value of the resourceName property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getResourceName()
   {
      return resourceName;
   }

   /**
    * Sets the value of the resourceName property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setResourceName(String value)
   {
      this.resourceName = value;
   }

   /**
    * Gets the value of the resourceObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getResourceObjectId()
   {
      return resourceObjectId;
   }

   /**
    * Sets the value of the resourceObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setResourceObjectId(Integer value)
   {
      this.resourceObjectId = value;
   }

   /**
    * Gets the value of the status property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getStatus()
   {
      return status;
   }

   /**
    * Sets the value of the status property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setStatus(String value)
   {
      this.status = value;
   }

   /**
    * Gets the value of the timesheetPeriodObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getTimesheetPeriodObjectId()
   {
      return timesheetPeriodObjectId;
   }

   /**
    * Sets the value of the timesheetPeriodObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setTimesheetPeriodObjectId(Integer value)
   {
      this.timesheetPeriodObjectId = value;
   }

   /**
    * Gets the value of the timesheetStatusDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getTimesheetStatusDate()
   {
      return timesheetStatusDate;
   }

   /**
    * Sets the value of the timesheetStatusDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setTimesheetStatusDate(Date value)
   {
      this.timesheetStatusDate = value;
   }

   /**
    * Gets the value of the unapprovedHours property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Double getUnapprovedHours()
   {
      return unapprovedHours;
   }

   /**
    * Sets the value of the unapprovedHours property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setUnapprovedHours(Double value)
   {
      this.unapprovedHours = value;
   }

   /**
    * Gets the value of the unapprovedOvertimeHours property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Double getUnapprovedOvertimeHours()
   {
      return unapprovedOvertimeHours;
   }

   /**
    * Sets the value of the unapprovedOvertimeHours property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setUnapprovedOvertimeHours(Double value)
   {
      this.unapprovedOvertimeHours = value;
   }

   /**
    * Gets the value of the wbsObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getWBSObjectId()
   {
      return wbsObjectId;
   }

   /**
    * Sets the value of the wbsObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setWBSObjectId(Integer value)
   {
      this.wbsObjectId = value;
   }

}