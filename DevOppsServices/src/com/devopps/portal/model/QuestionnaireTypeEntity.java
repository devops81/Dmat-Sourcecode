package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questionnaire_type")
public class QuestionnaireTypeEntity {
	
	private int questionTypeId;
	private String questionTypeName;
	
	/**
	 * @return the questionTypeId
	 */
	@Id
	@Column(name="question_type_id")
	public int getQuestionTypeId() {
		return questionTypeId;
	}
	/**
	 * @param questionTypeId the questionTypeId to set
	 */
	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	/**
	 * @return the questionTypeName
	 */
	@Column(name="question_type_name")
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	/**
	 * @param questionTypeName the questionTypeName to set
	 */
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	
	
	

}
