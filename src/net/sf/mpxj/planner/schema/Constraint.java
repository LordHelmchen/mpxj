//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2010.08.02 at 09:18:52 PM BST
//

package net.sf.mpxj.planner.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "") @XmlRootElement(name = "constraint") public class Constraint
{

   @XmlAttribute(required = true) @XmlJavaTypeAdapter(NormalizedStringAdapter.class) protected String type;
   @XmlAttribute(required = true) @XmlJavaTypeAdapter(NormalizedStringAdapter.class) protected String time;

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
      return type;
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
    * Gets the value of the time property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getTime()
   {
      return time;
   }

   /**
    * Sets the value of the time property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setTime(String value)
   {
      this.time = value;
   }

}
