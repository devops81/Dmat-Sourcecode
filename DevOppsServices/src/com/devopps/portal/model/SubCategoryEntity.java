package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subcategory_master")
public class SubCategoryEntity {
	
	private int subCategoryId;
	private String subCategoryName;
	private int questionnaireTypeId;
	private int activeFlag;
	private int subCategoryWeightage;
	/**
	 * @return the subCategoryId
	 */
	@Id
	@Column(name="subcategory_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSubCategoryId() {
		return subCategoryId;
	}
	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	/**
	 * @return the subCategoryName
	 */
	@Column(name="subcategory_Name")
	public String getSubCategoryName() {
		return subCategoryName;
	}
	
	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
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
	 * @return the activeFlag
	 */
	@Column(name="active_flag")
	public int getActiveFlag() {
		return activeFlag;
	}
	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	/**
	 * @return the subCategoryWeightage
	 */
	@Column(name="subcategory_weightage")
	public int getSubCategoryWeightage() {
		return subCategoryWeightage;
	}
	/**
	 * @param subCategoryWeightage the subCategoryWeightage to set
	 */
	public void setSubCategoryWeightage(int subCategoryWeightage) {
		this.subCategoryWeightage = subCategoryWeightage;
	}
	
	
}