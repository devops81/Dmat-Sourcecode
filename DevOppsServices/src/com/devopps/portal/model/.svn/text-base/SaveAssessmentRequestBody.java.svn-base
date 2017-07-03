package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"isAccountMapping",
    "assessmentId",
    "assessmentName",
    "applicationId",
    "weightage",
    "isActive"
})
@XmlRootElement(name = "saveAssessment")
public class SaveAssessmentRequestBody {
	
	
	@XmlElement(required = true)
	private boolean isAccountMapping;
	
	
	@XmlElement(required = true)
	private int assessmentId;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(AdapterXmlCDATA.class)
	private String assessmentName;
	
	@XmlElement(required = true)
	private int applicationId;
	
	@XmlElement(required = true)
	private int weightage;
	
	@XmlElement(required = true)
	private boolean isActive;
	
	/**
	 * @return the assessmentId
	 */
	public int getAssessmentId() {
		return assessmentId;
	}
	/**
	 * @param assessmentId the assessmentId to set
	 */
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}
	/**
	 * @return the assessmentName
	 */
	public String getAssessmentName() {
		return assessmentName;
	}
	/**
	 * @param assessmentName the assessmentName to set
	 */
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	/**
	 * @return the weightage
	 */
	public int getWeightage() {
		return weightage;
	}
	/**
	 * @param weightage the weightage to set
	 */
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the applicationId
	 */
	public int getApplicationId() {
		return applicationId;
	}
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @return the isAccountMapping
	 */
	public boolean isAccountMapping() {
		return isAccountMapping;
	}
	/**
	 * @param isAccountMapping the isAccountMapping to set
	 */
	public void setAccountMapping(boolean isAccountMapping) {
		this.isAccountMapping = isAccountMapping;
	}
	
	
}
