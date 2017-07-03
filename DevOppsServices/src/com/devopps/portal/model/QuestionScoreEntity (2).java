package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_score")
public class QuestionScoreEntity {
	
	private int id;
	private int questionId;
	private int scoreUser;
	private int scoreAdmin;
	private String comments;
	private String submittedBy;
	private int accountId;
	private int businessUnitId;
	private int applicationId;
	private int reportId;
	private int assessmentId;
	private boolean isAssessmentIdActive;
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the questionid
	 */
	
	@Column(name="questionId")
	public int getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionid the questionid to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the scoreUser
	 */
	@Column(name="score_user")
	public int getScoreUser() {
		return scoreUser;
	}
	/**
	 * @param scoreUser the scoreUser to set
	 */
	public void setScoreUser(int scoreUser) {
		this.scoreUser = scoreUser;
	}
	/**
	 * @return the scoreAdmin
	 */
	@Column(name="score_admin")
	public int getScoreAdmin() {
		return scoreAdmin;
	}
	/**
	 * @param scoreAdmin the scoreAdmin to set
	 */
	public void setScoreAdmin(int scoreAdmin) {
		this.scoreAdmin = scoreAdmin;
	}
	/**
	 * @return the comments
	 */
	@Column(name="comments")
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the submittedBy
	 */
	@Column(name="submitted_by")
	public String getSubmittedBy() {
		return submittedBy;
	}
	/**
	 * @param submittedBy the submittedBy to set
	 */
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	/**
	 * @return the accountId
	 */
	@Column(name="account_id")
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the businessUnitId
	 */
	@Column(name="business_unit_id")
	public int getBusinessUnitId() {
		return businessUnitId;
	}
	/**
	 * @param businessUnitId the businessUnitId to set
	 */
	public void setBusinessUnitId(int businessUnitId) {
		this.businessUnitId = businessUnitId;
	}
	/**
	 * @return the applicationId
	 */
	@Column(name="application_id")
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
	 * @return the reportId
	 */
	@Column(name="report_id")
	public int getReportId() {
		return reportId;
	}
	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
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
	 * @return the isAssessmentIdActive
	 */
	@Column(name="isAssessmentIdActive")
	public boolean isAssessmentIdActive() {
		return isAssessmentIdActive;
	}
	/**
	 * @param isAssessmentIdActive the isAssessmentIdActive to set
	 */
	public void setAssessmentIdActive(boolean isAssessmentIdActive) {
		this.isAssessmentIdActive = isAssessmentIdActive;
	}
	
}
