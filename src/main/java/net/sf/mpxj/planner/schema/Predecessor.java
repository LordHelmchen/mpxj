//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.10.13 at 10:14:19 PM BST
//

package net.sf.mpxj.planner.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * &lt;p&gt;Java class for anonymous complex type.
 *
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 *
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="predecessor-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="type" default="FS"&amp;gt;
 *         &amp;lt;simpleType&amp;gt;
 *           &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&amp;gt;
 *             &amp;lt;enumeration value="FS"/&amp;gt;
 *             &amp;lt;enumeration value="FF"/&amp;gt;
 *             &amp;lt;enumeration value="SS"/&amp;gt;
 *             &amp;lt;enumeration value="SF"/&amp;gt;
 *           &amp;lt;/restriction&amp;gt;
 *         &amp;lt;/simpleType&amp;gt;
 *       &amp;lt;/attribute&amp;gt;
 *       &amp;lt;attribute name="lag" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@SuppressWarnings("all") @XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "") @XmlRootElement(name = "predecessor") public class Predecessor
{

   @XmlAttribute(name = "id", required = true) protected String id;
   @XmlAttribute(name = "predecessor-id", required = true) protected String predecessorId;
   @XmlAttribute(name = "type") @XmlJavaTypeAdapter(CollapsedStringAdapter.class) protected String type;
   @XmlAttribute(name = "lag") protected String lag;

   /**
    * Gets the value of the id property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getId()
   {
      return id;
   }

   /**
    * Sets the value of the id property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setId(String value)
   {
      this.id = value;
   }

   /**
    * Gets the value of the predecessorId property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getPredecessorId()
   {
      return predecessorId;
   }

   /**
    * Sets the value of the predecessorId property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setPredecessorId(String value)
   {
      this.predecessorId = value;
   }

   /**
    * Gets the value of the type property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getType()
   {
      if (type == null)
      {
         return "FS";
      }
      else
      {
         return type;
      }
   }

   /**
    * Sets the value of the type property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setType(String value)
   {
      this.type = value;
   }

   /**
    * Gets the value of the lag property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getLag()
   {
      return lag;
   }

   /**
    * Sets the value of the lag property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setLag(String value)
   {
      this.lag = value;
   }

}