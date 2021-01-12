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
 * &lt;p&gt;Java class for UDFTypeType complex type.
 *
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="UDFTypeType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="CreateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CreateUser" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="255"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="DataType" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;enumeration value="Text"/&amp;gt;
 *               &amp;lt;enumeration value="Start Date"/&amp;gt;
 *               &amp;lt;enumeration value="Finish Date"/&amp;gt;
 *               &amp;lt;enumeration value="Cost"/&amp;gt;
 *               &amp;lt;enumeration value="Double"/&amp;gt;
 *               &amp;lt;enumeration value="Integer"/&amp;gt;
 *               &amp;lt;enumeration value="Indicator"/&amp;gt;
 *               &amp;lt;enumeration value="Code"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="Formula" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="4000"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="IsCalculated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsConditional" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="IsSecureCode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="LastUpdateUser" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="255"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="ObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="SubjectArea" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;enumeration value="Activity"/&amp;gt;
 *               &amp;lt;enumeration value="Activity Expense"/&amp;gt;
 *               &amp;lt;enumeration value="Activity Step"/&amp;gt;
 *               &amp;lt;enumeration value="Project"/&amp;gt;
 *               &amp;lt;enumeration value="Project Issue"/&amp;gt;
 *               &amp;lt;enumeration value="Project Risk"/&amp;gt;
 *               &amp;lt;enumeration value="Resource"/&amp;gt;
 *               &amp;lt;enumeration value="Resource Assignment"/&amp;gt;
 *               &amp;lt;enumeration value="WBS"/&amp;gt;
 *               &amp;lt;enumeration value="Work Products and Documents"/&amp;gt;
 *               &amp;lt;enumeration value="Activity Step Template Item"/&amp;gt;
 *               &amp;lt;enumeration value="Lean Task"/&amp;gt;
 *               &amp;lt;enumeration value="Roles"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="SummaryMethod" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="60"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="Title" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;maxLength value="40"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "UDFTypeType", propOrder =
{
   "createDate",
   "createUser",
   "dataType",
   "formula",
   "isCalculated",
   "isConditional",
   "isSecureCode",
   "lastUpdateDate",
   "lastUpdateUser",
   "objectId",
   "subjectArea",
   "summaryMethod",
   "title"
}) public class UDFTypeType
{

   @XmlElement(name = "CreateDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter3.class) @XmlSchemaType(name = "dateTime") protected Date createDate;
   @XmlElement(name = "CreateUser") protected String createUser;
   @XmlElement(name = "DataType") protected String dataType;
   @XmlElement(name = "Formula") protected String formula;
   @XmlElement(name = "IsCalculated", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "boolean") protected Boolean isCalculated;
   @XmlElement(name = "IsConditional", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "boolean") protected Boolean isConditional;
   @XmlElement(name = "IsSecureCode", type = String.class) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "boolean") protected Boolean isSecureCode;
   @XmlElement(name = "LastUpdateDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter3.class) @XmlSchemaType(name = "dateTime") protected Date lastUpdateDate;
   @XmlElement(name = "LastUpdateUser") protected String lastUpdateUser;
   @XmlElement(name = "ObjectId") protected Integer objectId;
   @XmlElement(name = "SubjectArea") protected String subjectArea;
   @XmlElement(name = "SummaryMethod") protected String summaryMethod;
   @XmlElement(name = "Title") protected String title;

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
    * Gets the value of the dataType property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getDataType()
   {
      return dataType;
   }

   /**
    * Sets the value of the dataType property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setDataType(String value)
   {
      this.dataType = value;
   }

   /**
    * Gets the value of the formula property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getFormula()
   {
      return formula;
   }

   /**
    * Sets the value of the formula property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setFormula(String value)
   {
      this.formula = value;
   }

   /**
    * Gets the value of the isCalculated property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public Boolean isIsCalculated()
   {
      return isCalculated;
   }

   /**
    * Sets the value of the isCalculated property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setIsCalculated(Boolean value)
   {
      this.isCalculated = value;
   }

   /**
    * Gets the value of the isConditional property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public Boolean isIsConditional()
   {
      return isConditional;
   }

   /**
    * Sets the value of the isConditional property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setIsConditional(Boolean value)
   {
      this.isConditional = value;
   }

   /**
    * Gets the value of the isSecureCode property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public Boolean isIsSecureCode()
   {
      return isSecureCode;
   }

   /**
    * Sets the value of the isSecureCode property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setIsSecureCode(Boolean value)
   {
      this.isSecureCode = value;
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
    * Gets the value of the subjectArea property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getSubjectArea()
   {
      return subjectArea;
   }

   /**
    * Sets the value of the subjectArea property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setSubjectArea(String value)
   {
      this.subjectArea = value;
   }

   /**
    * Gets the value of the summaryMethod property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getSummaryMethod()
   {
      return summaryMethod;
   }

   /**
    * Sets the value of the summaryMethod property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setSummaryMethod(String value)
   {
      this.summaryMethod = value;
   }

   /**
    * Gets the value of the title property.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getTitle()
   {
      return title;
   }

   /**
    * Sets the value of the title property.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setTitle(String value)
   {
      this.title = value;
   }

}
