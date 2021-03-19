/*
 * file:       ProjectField.java
 * author:     Jon Iles
 * copyright:  (c) Packwood Software 2015
 * date:       22/03/2015
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

package net.sf.mpxj;

import java.util.EnumSet;
import java.util.Locale;

/**
 * Instances of this type represent project properties.
 */
public enum ProjectField implements FieldType
{
   START_DATE(DataType.DATE), // Must always be first value
   CURRENCY_SYMBOL(DataType.STRING),
   CURRENCY_SYMBOL_POSITION(DataType.CURRENCY_SYMBOL_POSITION),
   CURRENCY_DIGITS(DataType.INTEGER),
   THOUSANDS_SEPARATOR(DataType.CHAR),
   DECIMAL_SEPARATOR(DataType.CHAR),
   DEFAULT_DURATION_UNITS(DataType.TIME_UNITS),
   DEFAULT_DURATION_IS_FIXED(DataType.BOOLEAN),
   DEFAULT_WORK_UNITS(DataType.TIME_UNITS),
   DEFAULT_STANDARD_RATE(DataType.RATE),
   DEFAULT_OVERTIME_RATE(DataType.RATE),
   UPDATING_TASK_STATUS_UPDATES_RESOURCE_STATUS(DataType.BOOLEAN),
   SPLIT_IN_PROGRESS_TASKS(DataType.BOOLEAN),
   DATE_ORDER(DataType.DATE_ORDER),
   TIME_FORMAT(DataType.PROJECT_TIME_FORMAT),
   DEFAULT_START_TIME(DataType.DATE),
   DATE_SEPARATOR(DataType.CHAR),
   TIME_SEPARATOR(DataType.CHAR),
   AM_TEXT(DataType.STRING),
   PM_TEXT(DataType.STRING),
   DATE_FORMAT(DataType.PROJECT_DATE_FORMAT),
   BAR_TEXT_DATE_FORMAT(DataType.PROJECT_DATE_FORMAT),
   PROJECT_TITLE(DataType.STRING),
   COMPANY(DataType.STRING),
   MANAGER(DataType.STRING),
   DEFAULT_CALENDAR_NAME(DataType.STRING),
   SCHEDULE_FROM(DataType.SCHEDULE_FROM),
   CURRENT_DATE(DataType.DATE),
   COMMENTS(DataType.STRING),
   COST(DataType.CURRENCY),
   BASELINE_COST(DataType.CURRENCY),
   ACTUAL_COST(DataType.CURRENCY),
   WORK(DataType.WORK),
   BASELINE_WORK(DataType.WORK),
   ACTUAL_WORK(DataType.WORK),
   WORK2(DataType.NUMERIC),
   DURATION(DataType.DURATION),
   BASELINE_DURATION(DataType.DURATION),
   ACTUAL_DURATION(DataType.DURATION),
   PERCENTAGE_COMPLETE(DataType.PERCENTAGE),
   BASELINE_START(DataType.DATE),
   BASELINE_FINISH(DataType.DATE),
   ACTUAL_START(DataType.DATE),
   ACTUAL_FINISH(DataType.DATE),
   START_VARIANCE(DataType.DURATION),
   FINISH_VARIANCE(DataType.DURATION),
   SUBJECT(DataType.STRING),
   AUTHOR(DataType.STRING),
   KEYWORDS(DataType.STRING),
   HYPERLINK_BASE(DataType.STRING),
   DEFAULT_END_TIME(DataType.DATE),
   PROJECT_EXTERNALLY_EDITED(DataType.BOOLEAN),
   CATEGORY(DataType.STRING),
   MINUTES_PER_DAY(DataType.INTEGER),
   DAYS_PER_MONTH(DataType.INTEGER),
   MINUTES_PER_WEEK(DataType.INTEGER),
   FISCAL_YEAR_START(DataType.BOOLEAN),
   DEFAULT_TASK_EARNED_VALUE_METHOD(DataType.EARNED_VALUE_METHOD),
   REMOVE_FILE_PROPERTIES(DataType.BOOLEAN),
   MOVE_COMPLETED_ENDS_BACK(DataType.BOOLEAN),
   NEW_TASKS_ESTIMATED(DataType.BOOLEAN),
   SPREAD_ACTUAL_COST(DataType.BOOLEAN),
   MULTIPLE_CRITICAL_PATHS(DataType.BOOLEAN),
   AUTO_ADD_NEW_RESOURCES_AND_TASKS(DataType.BOOLEAN),
   LAST_SAVED(DataType.DATE),
   STATUS_DATE(DataType.DATE),
   MOVE_REMAINING_STARTS_BACK(DataType.BOOLEAN),
   AUTO_LINK(DataType.BOOLEAN),
   MICROSOFT_PROJECT_SERVER_URL(DataType.BOOLEAN),
   HONOR_CONSTRAINTS(DataType.BOOLEAN),
   ADMIN_PROJECT(DataType.BOOLEAN),
   INSERTED_PROJECTS_LIKE_SUMMARY(DataType.BOOLEAN),
   NAME(DataType.STRING),
   SPREAD_PERCENT_COMPLETE(DataType.BOOLEAN),
   MOVE_COMPLETED_ENDS_FORWARD(DataType.BOOLEAN),
   EDITABLE_ACTUAL_COSTS(DataType.BOOLEAN),
   UNIQUE_ID(DataType.INTEGER),
   REVISION(DataType.INTEGER),
   NEW_TASKS_EFFORT_DRIVEN(DataType.BOOLEAN),
   MOVE_REMAINING_STARTS_FORWARD(DataType.BOOLEAN),
   ACTUALS_IN_SYNC(DataType.BOOLEAN),
   DEFAULT_TASK_TYPE(DataType.TASK_TYPE),
   EARNED_VALUE_METHOD(DataType.EARNED_VALUE_METHOD),
   CREATION_DATE(DataType.DATE),
   EXTENDED_CREATION_DATE(DataType.DATE),
   DEFAULT_FIXED_COST_ACCRUAL(DataType.ACCRUE),
   CRITICAL_SLACK_LIMIT(DataType.INTEGER),
   BASELINE_FOR_EARNED_VALUE(DataType.INTEGER),
   FISCAL_YEAR_START_MONTH(DataType.INTEGER),
   NEW_TASK_START_IS_PROJECT_START(DataType.BOOLEAN),
   NEW_TASKS_ARE_MANUAL(DataType.BOOLEAN),
   WEEK_START_DAY(DataType.DAY),
   CUSTOM_PROPERTIES(DataType.MAP),
   CURRENCY_CODE(DataType.STRING),
   SHOW_PROJECT_SUMMARY_TASK(DataType.BOOLEAN),
   BASELINE_DATE(DataType.DATE),
   BASELINE1_DATE(DataType.DATE),
   BASELINE2_DATE(DataType.DATE),
   BASELINE3_DATE(DataType.DATE),
   BASELINE4_DATE(DataType.DATE),
   BASELINE5_DATE(DataType.DATE),
   BASELINE6_DATE(DataType.DATE),
   BASELINE7_DATE(DataType.DATE),
   BASELINE8_DATE(DataType.DATE),
   BASELINE9_DATE(DataType.DATE),
   BASELINE10_DATE(DataType.DATE),
   TEMPLATE(DataType.STRING),
   LAST_AUTHOR(DataType.STRING),
   LASTPRINTED(DataType.DATE),
   SHORT_APPLICATION_NAME(DataType.STRING),
   EDITING_TIME(DataType.INTEGER),
   PRESENTATION_FORMAT(DataType.STRING),
   CONTENT_TYPE(DataType.STRING),
   CONTENT_STATUS(DataType.STRING),
   LANGUAGE(DataType.STRING),
   DOCUMENT_VERSION(DataType.STRING),
   MPX_DELIMITER(DataType.CHAR),
   MPX_PROGRAM_NAME(DataType.STRING),
   MPX_FILE_VERSION(DataType.MPX_FILE_VERSION),
   MPX_CODE_PAGE(DataType.MPX_CODE_PAGE),
   PROJECT_FILE_PATH(DataType.STRING),
   FULL_APPLICATION_NAME(DataType.STRING),
   APPLICATION_VERSION(DataType.INTEGER),
   MPP_FILE_TYPE(DataType.INTEGER),
   AUTOFILTER(DataType.BOOLEAN),
   FILE_APPLICATION(DataType.STRING),
   FILE_TYPE(DataType.STRING),
   EXPORT_FLAG(DataType.BOOLEAN),
   GUID(DataType.GUID),
   PROJECT_ID(DataType.STRING),
   BASELINE_PROJECT_UNIQUE_ID(DataType.INTEGER),
   CRITICAL_ACTIVITY_TYPE(DataType.CRITICAL_ACTIVITY_TYPE),
   
   // KEEP THESE TOGETHER AND IN ORDER
   ENTERPRISE_CUSTOM_FIELD1(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD2(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD3(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD4(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD5(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD6(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD7(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD8(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD9(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD10(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD11(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD12(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD13(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD14(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD15(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD16(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD17(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD18(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD19(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD20(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD21(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD22(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD23(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD24(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD25(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD26(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD27(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD28(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD29(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD30(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD31(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD32(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD33(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD34(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD35(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD36(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD37(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD38(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD39(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD40(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD41(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD42(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD43(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD44(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD45(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD46(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD47(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD48(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD49(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD50(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD51(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD52(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD53(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD54(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD55(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD56(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD57(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD58(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD59(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD60(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD61(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD62(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD63(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD64(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD65(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD66(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD67(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD68(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD69(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD70(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD71(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD72(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD73(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD74(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD75(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD76(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD77(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD78(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD79(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD80(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD81(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD82(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD83(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD84(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD85(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD86(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD87(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD88(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD89(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD90(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD91(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD92(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD93(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD94(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD95(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD96(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD97(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD98(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD99(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD100(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD101(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD102(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD103(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD104(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD105(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD106(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD107(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD108(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD109(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD110(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD111(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD112(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD113(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD114(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD115(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD116(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD117(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD118(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD119(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD120(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD121(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD122(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD123(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD124(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD125(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD126(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD127(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD128(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD129(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD130(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD131(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD132(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD133(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD134(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD135(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD136(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD137(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD138(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD139(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD140(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD141(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD142(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD143(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD144(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD145(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD146(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD147(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD148(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD149(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD150(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD151(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD152(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD153(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD154(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD155(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD156(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD157(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD158(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD159(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD160(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD161(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD162(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD163(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD164(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD165(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD166(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD167(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD168(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD169(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD170(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD171(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD172(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD173(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD174(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD175(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD176(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD177(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD178(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD179(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD180(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD181(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD182(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD183(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD184(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD185(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD186(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD187(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD188(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD189(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD190(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD191(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD192(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD193(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD194(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD195(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD196(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD197(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD198(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD199(DataType.BINARY),
   ENTERPRISE_CUSTOM_FIELD200(DataType.BINARY),
   // KEEP THESE TOGETHER AND IN ORDER

   FINISH_DATE(DataType.DATE); // Must always be last value

   /**
    * Constructor.
    *
    * @param dataType field data type
    * @param unitsType field units type
    */
   private ProjectField(DataType dataType, FieldType unitsType)
   {
      m_dataType = dataType;
      m_unitsType = unitsType;
   }

   /**
    * Constructor.
    *
    * @param dataType field data type
    */
   private ProjectField(DataType dataType)
   {
      this(dataType, null);
   }

   /**
    * {@inheritDoc}
    */
   @Override public FieldTypeClass getFieldTypeClass()
   {
      return FieldTypeClass.PROJECT;
   }

   /**
    * {@inheritDoc}
    */
   @Override public String getName()
   {
      return (getName(Locale.ENGLISH));
   }

   /**
    * {@inheritDoc}
    */
   @Override public String getName(Locale locale)
   {
      String[] titles = LocaleData.getStringArray(locale, LocaleData.PROJECT_COLUMNS);
      String result = null;

      if (m_value >= 0 && m_value < titles.length)
      {
         result = titles[m_value];
      }

      return (result);
   }

   /**
    * {@inheritDoc}
    */
   @Override public int getValue()
   {
      return (m_value);
   }

   /**
    * {@inheritDoc}
    */
   @Override public DataType getDataType()
   {
      return (m_dataType);
   }

   /**
    * {@inheritDoc}
    */
   @Override public FieldType getUnitsType()
   {
      return m_unitsType;
   }

   /**
    * Retrieves the string representation of this instance.
    *
    * @return string representation
    */
   @Override public String toString()
   {
      return (getName());
   }

   /**
    * This method takes the integer enumeration of a property field
    * and returns an appropriate class instance.
    *
    * @param type integer property field enumeration
    * @return PropertyField instance
    */
   public static ProjectField getInstance(int type)
   {
      ProjectField result = null;

      if (type >= 0 && type < MAX_VALUE)
      {
         result = TYPE_VALUES[type];
      }

      return (result);
   }

   public static final int MAX_VALUE = EnumSet.allOf(ProjectField.class).size();
   private static final ProjectField[] TYPE_VALUES = new ProjectField[MAX_VALUE];
   static
   {
      int value = 0;
      for (ProjectField e : EnumSet.allOf(ProjectField.class))
      {
         e.m_value = value++;
         TYPE_VALUES[e.getValue()] = e;
      }
   }

   private int m_value;
   private DataType m_dataType;
   private FieldType m_unitsType;
}
