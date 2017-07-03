package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_category_mapping")
public class AssessmentCategoryEntity {
	
	private int assessmentId;
	private int categoryId;
	private int categoryWeightage; 
	
	/**
	 * @return the assessmentId
	 */
	@Column(name="assessment_id")
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
	@Id
	@Column(name="category_id")
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
	 * @param categoryWeightage the categoryWeightage to set
	 */
	public void setCategoryWeightage(int categoryWeightage) {
		this.categoryWeightage = categoryWeightage;
	}
	/**
	 * @return the categoryWeightage
	 */
	@Column(name="category_weightage")
	public int getCategoryWeightage() {
		return categoryWeightage;
	}
	
}