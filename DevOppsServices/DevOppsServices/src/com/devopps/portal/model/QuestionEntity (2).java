package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_master")
public class QuestionEntity {
	
	private int questionId;
	private int questionnaireType;
	private int assessmentId;
	private int categoryId;
	private int subcategoryId;
	private String questionText;
	private int isActive;
	
	/**
	 * @return the questionId
	 */
	@Id
	@Column(name="questionId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	
	/**
	 * @return the questionnaire_type
	 */
	@Column(name="questionnaire_type")
	public int getQuestionnaireType() {
		return questionnaireType;
	}
	/**
	 * @param questionnaire_type the questionnaire_type to set
	 */
	public void setQuestionnaireType(int questionnaireType) {
		this.questionnaireType = questionnaireType;
	}
	
	/**
	 * @return the assessmentId
	 */
	@Column(name="assessment_Id")
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
	 * @return the categoryId
	 */
	@Column(name="category_Id")
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
	 * @return the subcategoryId
	 */
	@Column(name="subCategory_Id")
	public int getSubcategoryId() {
		return subcategoryId;
	}
	/**
	 * @param subcategoryId the subcategoryId to set
	 */
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	/**
	 * @return the questionText
	 */
	@Column(name="question_Description")
	public String getQuestionText() {
		return questionText;
	}
	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	/**
	 * @return the isActive
	 */
	@Column(name="isActive")
	public int getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the isActive
	 */
}