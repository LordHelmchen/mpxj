//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.10.22 at 02:49:21 PM BST
//

package net.sf.mpxj.mspdi.schema;

import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The definition of the time phased data block.
 *
 * &lt;p&gt;Java class for TimephasedDataType complex type.
 *
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="TimephasedDataType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Type" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&amp;gt;
 *               &amp;lt;enumeration value="1"/&amp;gt;
 *               &amp;lt;enumeration value="2"/&amp;gt;
 *               &amp;lt;enumeration value="3"/&amp;gt;
 *               &amp;lt;enumeration value="4"/&amp;gt;
 *               &amp;lt;enumeration value="5"/&amp;gt;
 *               &amp;lt;enumeration value="6"/&amp;gt;
 *               &amp;lt;enumeration value="7"/&amp;gt;
 *               &amp;lt;enumeration value="8"/&amp;gt;
 *               &amp;lt;enumeration value="9"/&amp;gt;
 *               &amp;lt;enumeration value="10"/&amp;gt;
 *               &amp;lt;enumeration value="11"/&amp;gt;
 *               &amp;lt;enumeration value="16"/&amp;gt;
 *               &amp;lt;enumeration value="17"/&amp;gt;
 *               &amp;lt;enumeration value="18"/&amp;gt;
 *               &amp;lt;enumeration value="19"/&amp;gt;
 *               &amp;lt;enumeration value="20"/&amp;gt;
 *               &amp;lt;enumeration value="21"/&amp;gt;
 *               &amp;lt;enumeration value="22"/&amp;gt;
 *               &amp;lt;enumeration value="23"/&amp;gt;
 *               &amp;lt;enumeration value="24"/&amp;gt;
 *               &amp;lt;enumeration value="25"/&amp;gt;
 *               &amp;lt;enumeration value="26"/&amp;gt;
 *               &amp;lt;enumeration value="27"/&amp;gt;
 *               &amp;lt;enumeration value="28"/&amp;gt;
 *               &amp;lt;enumeration value="29"/&amp;gt;
 *               &amp;lt;enumeration value="30"/&amp;gt;
 *               &amp;lt;enumeration value="31"/&amp;gt;
 *               &amp;lt;enumeration value="32"/&amp;gt;
 *               &amp;lt;enumeration value="33"/&amp;gt;
 *               &amp;lt;enumeration value="34"/&amp;gt;
 *               &amp;lt;enumeration value="35"/&amp;gt;
 *               &amp;lt;enumeration value="36"/&amp;gt;
 *               &amp;lt;enumeration value="37"/&amp;gt;
 *               &amp;lt;enumeration value="38"/&amp;gt;
 *               &amp;lt;enumeration value="39"/&amp;gt;
 *               &amp;lt;enumeration value="40"/&amp;gt;
 *               &amp;lt;enumeration value="41"/&amp;gt;
 *               &amp;lt;enumeration value="42"/&amp;gt;
 *               &amp;lt;enumeration value="43"/&amp;gt;
 *               &amp;lt;enumeration value="44"/&amp;gt;
 *               &amp;lt;enumeration value="45"/&amp;gt;
 *               &amp;lt;enumeration value="46"/&amp;gt;
 *               &amp;lt;enumeration value="47"/&amp;gt;
 *               &amp;lt;enumeration value="48"/&amp;gt;
 *               &amp;lt;enumeration value="49"/&amp;gt;
 *               &amp;lt;enumeration value="50"/&amp;gt;
 *               &amp;lt;enumeration value="51"/&amp;gt;
 *               &amp;lt;enumeration value="52"/&amp;gt;
 *               &amp;lt;enumeration value="53"/&amp;gt;
 *               &amp;lt;enumeration value="54"/&amp;gt;
 *               &amp;lt;enumeration value="55"/&amp;gt;
 *               &amp;lt;enumeration value="56"/&amp;gt;
 *               &amp;lt;enumeration value="57"/&amp;gt;
 *               &amp;lt;enumeration value="58"/&amp;gt;
 *               &amp;lt;enumeration value="59"/&amp;gt;
 *               &amp;lt;enumeration value="60"/&amp;gt;
 *               &amp;lt;enumeration value="61"/&amp;gt;
 *               &amp;lt;enumeration value="62"/&amp;gt;
 *               &amp;lt;enumeration value="63"/&amp;gt;
 *               &amp;lt;enumeration value="64"/&amp;gt;
 *               &amp;lt;enumeration value="65"/&amp;gt;
 *               &amp;lt;enumeration value="66"/&amp;gt;
 *               &amp;lt;enumeration value="67"/&amp;gt;
 *               &amp;lt;enumeration value="68"/&amp;gt;
 *               &amp;lt;enumeration value="69"/&amp;gt;
 *               &amp;lt;enumeration value="70"/&amp;gt;
 *               &amp;lt;enumeration value="71"/&amp;gt;
 *               &amp;lt;enumeration value="72"/&amp;gt;
 *               &amp;lt;enumeration value="73"/&amp;gt;
 *               &amp;lt;enumeration value="74"/&amp;gt;
 *               &amp;lt;enumeration value="75"/&amp;gt;
 *               &amp;lt;enumeration value="76"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="UID" type="{http://www.w3.org/2001/XMLSchema}integer"/&amp;gt;
 *         &amp;lt;element name="Start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Finish" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Unit" minOccurs="0"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&amp;gt;
 *               &amp;lt;enumeration value="0"/&amp;gt;
 *               &amp;lt;enumeration value="1"/&amp;gt;
 *               &amp;lt;enumeration value="2"/&amp;gt;
 *               &amp;lt;enumeration value="3"/&amp;gt;
 *               &amp;lt;enumeration value="5"/&amp;gt;
 *               &amp;lt;enumeration value="8"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@SuppressWarnings("all") @XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "TimephasedDataType", propOrder =
{
   "type",
   "uid",
   "start",
   "finish",
   "unit",
   "value"
}) public class TimephasedDataType
{

   @XmlElement(name = "Type") protected BigInteger type;
   @XmlElement(name = "UID", required = true) protected BigInteger uid;
   @XmlElement(name = "Start", type = String.class) @XmlJavaTypeAdapter(Adapter4.class) @XmlSchemaType(name = "dateTime") protected Date start;
   @XmlElement(name = "Finish", type = String.class) @XmlJavaTypeAdapter(Adapter4.class) @XmlSchemaType(name = "dateTime") protected Date finish;
   @XmlElement(name = "Unit") protected BigInteger unit;
   @XmlElement(name = "Value") protected String value;

   /**
    * Gets the value of the type property.
    *
    * @return
    *     possible object is
    *     {@link BigInteger }
    *
    */
   public BigInteger getType()
   {
      return type;
   }

   /**
    * Sets the value of the type property.
    *
    * @param value
    *     allowed object is
    *     {@link BigInteger }
    *
    */
   public void setType(BigInteger value)
   {
      this.type = value;
   }

   /**
    * Gets the value of the uid property.
    *
    * @return
    *     possible object is
    *     {@link BigInteger }
    *
    */
   public BigInteger getUID()
   {
      return uid;
   }

   /**
    * Sets the value of the uid property.
    *
    * @param value
    *     allowed object is
    *     {@link BigInteger }
    *
    */
   public void setUID(BigInteger value)
   {
      this.uid = value;
   }

   /**
    * Gets the value of the start property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getStart()
   {
      return start;
   }

   /**
    * Sets the value of the start property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setStart(Date value)
   {
      this.start = value;
   }

   /**
    * Gets the value of the finish property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getFinish()
   {
      return finish;
   }

   /**
    * Sets the value of the finish property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setFinish(Date value)
   {
      this.finish = value;
   }

   /**
    * Gets the value of the unit property.
    *
    * @return
    *     possible object is
    *     {@link BigInteger }
    *
    */
   public BigInteger getUnit()
   {
      return unit;
   }

   /**
    * Sets the value of the unit property.
    *
    * @param value
    *     allowed object is
    *     {@link BigInteger }
    *
    */
   public void setUnit(BigInteger value)
   {
      this.unit = value;
   }

   /**
    * Gets the value of the value property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getValue()
   {
      return value;
   }

   /**
    * Sets the value of the value property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setValue(String value)
   {
      this.value = value;
   }

}