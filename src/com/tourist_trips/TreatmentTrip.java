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
 * <p>Java class for TreatmentTrip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TreatmentTrip">
 *   &lt;complexContent>
 *     &lt;extension base="{}Trip">
 *       &lt;sequence>
 *         &lt;element name="MedicalProgram" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DoctorConsultationIncluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NumberOfTherapies" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TreatmentTrip", propOrder = {
    "medicalProgram",
    "doctorConsultationIncluded",
    "numberOfTherapies"
})
public class TreatmentTrip
    extends Trip
{

    @XmlElement(name = "MedicalProgram", required = true)
    protected String medicalProgram;
    @XmlElement(name = "DoctorConsultationIncluded")
    protected boolean doctorConsultationIncluded;
    @XmlElement(name = "NumberOfTherapies")
    protected int numberOfTherapies;

    /**
     * Gets the value of the medicalProgram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalProgram() {
        return medicalProgram;
    }

    /**
     * Sets the value of the medicalProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalProgram(String value) {
        this.medicalProgram = value;
    }

    /**
     * Gets the value of the doctorConsultationIncluded property.
     * 
     */
    public boolean isDoctorConsultationIncluded() {
        return doctorConsultationIncluded;
    }

    /**
     * Sets the value of the doctorConsultationIncluded property.
     * 
     */
    public void setDoctorConsultationIncluded(boolean value) {
        this.doctorConsultationIncluded = value;
    }

    /**
     * Gets the value of the numberOfTherapies property.
     * 
     */
    public int getNumberOfTherapies() {
        return numberOfTherapies;
    }

    /**
     * Sets the value of the numberOfTherapies property.
     * 
     */
    public void setNumberOfTherapies(int value) {
        this.numberOfTherapies = value;
    }

}
