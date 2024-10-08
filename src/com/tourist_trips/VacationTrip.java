//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.09.22 at 12:36:25 AM EEST 
//


package com.tourist_trips;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;



/**
 * <p>Java class for VacationTrip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VacationTrip">
 *   &lt;complexContent>
 *     &lt;extension base="{}Trip">
 *       &lt;sequence>
 *         &lt;element name="ResortType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StarRating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BeachAccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VacationTrip", propOrder = {
    "resortType",
    "starRating",
    "beachAccess"
})
public class VacationTrip
    extends Trip
{


    @XmlElement(name = "ResortType", required = true)
    protected String resortType;
    @XmlElement(name = "StarRating")
    protected int starRating;
    @XmlElement(name = "BeachAccess")
    protected boolean beachAccess;

    /**
     * Gets the value of the resortType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResortType() {
        return resortType;
    }

    /**
     * Sets the value of the resortType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResortType(String value) {
        this.resortType = value;
    }

    /**
     * Gets the value of the starRating property.
     * 
     */
    public int getStarRating() {
        return starRating;
    }

    /**
     * Sets the value of the starRating property.
     * 
     */
    public void setStarRating(int value) {
        this.starRating = value;
    }

    /**
     * Gets the value of the beachAccess property.
     * 
     */
    public boolean isBeachAccess() {
        return beachAccess;
    }

    /**
     * Sets the value of the beachAccess property.
     * 
     */
    public void setBeachAccess(boolean value) {
        this.beachAccess = value;
    }

}
