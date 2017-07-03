package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_score")
public class QuestionScoreEntity {
	
	private int questionId;
	private int scoreUser;
	private int scoreAdmin;
	private String comments;
	private String submittedBy;
	
	/**
	 * @return the questionid
	 */
	@Id
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
	
}
