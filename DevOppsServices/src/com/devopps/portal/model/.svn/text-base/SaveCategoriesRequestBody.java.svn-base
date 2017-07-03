package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "categoryId",
    "categoryName",
    "assessmentId",
    "weightage",
    "isActive",
    "questionnaireType"
})
@XmlRootElement(name = "saveupdateRequest")
public class SaveCategoriesRequestBody {
	
	
	@XmlElement(required = true)
	private int categoryId;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(AdapterXmlCDATA.class)
	private String categoryName;
	
	@XmlElement(required = true)
	private int assessmentId;
	
	@XmlElement(required = true)
	private int weightage;
	
	@XmlElement(required = true)
	private boolean isActive;
	
	@XmlElement(required = true)
	private int questionnaireType;
	
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
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
	 * @return the questionnaireType
	 */
	public int getQuestionnaireType() {
		return questionnaireType;
	}
	/**
	 * @param questionnaireType the questionnaireType to set
	 */
	public void setQuestionnaireType(int questionnaireType) {
		this.questionnaireType = questionnaireType;
	}
	
	
}
