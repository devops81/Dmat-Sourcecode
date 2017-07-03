package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_master")
public class CategoryEntity {
	
	private int categoryId;
	private String categoryName;
	private int questionnaireTypeId;
	private int activeFlag;
	private int categoryWeightage;
	
	/**
	 * @return the categoryId
	 */
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@Column(name="category_Name")
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
	 * @return the questionnaireTypeId
	 */
	@Column(name="questionnaire_type_id")
	public int getQuestionnaireTypeId() {
		return questionnaireTypeId;
	}
	/**
	 * @param questionnaireTypeId the questionnaireTypeId to set
	 */
	public void setQuestionnaireTypeId(int questionnaireTypeId) {
		this.questionnaireTypeId = questionnaireTypeId;
	}
	/**
	 * @return the categoryWeightage
	 */
	@Column(name="category_weightage")
	public int getCategoryWeightage() {
		return categoryWeightage;
	}
	/**
	 * @param categoryWeightage the categoryWeightage to set
	 */
	public void setCategoryWeightage(int categoryWeightage) {
		this.categoryWeightage = categoryWeightage;
	}
	/**
	 * @return the activeFlag
	 */
	@Column(name="active_Flag")
	public int getActiveFlag() {
		return activeFlag;
	}
	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
