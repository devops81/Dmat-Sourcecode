package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_master")
public class AssessmentEntity {
	
	private int assessmentId;
	private String assessmentAreaName;
	private int weightage;
	private int activeFlag;
	
	/**
	 * @return the assessmentId
	 */
	@Id
	@Column(name="assessment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@Column(name="assessment_name")
	public String getAssessmentAreaName() {
		return assessmentAreaName;
	}
	/**
	 * @param assessmentName the assessmentName to set
	 */
	public void setAssessmentAreaName(String assessmentAreaName) {
		this.assessmentAreaName = assessmentAreaName;
	}
	/**
	 * @return the assessmentWeightage
	 */
	@Column(name="assessment_weightage")
	public int getWeightage() {
		return weightage;
	}
	/**
	 * @param assessmentWeightage the assessmentWeightage to set
	 */
	public void setWeightage(int weightage) {
		this.weightage = weightage;
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
	
}
