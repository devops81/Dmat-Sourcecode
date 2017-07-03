package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_indicative_values")
public class QuestionIndicatorValuesEntity {
	
	private int questionId;
	private String optionOneVal;
	private String optionTwoVal;
	private String optionThreeVal;
	private String optionFourVal;
	private String optionFiveVal;
	/**
	 * @return the questionId
	 */
	@Id
	@Column(name="questionId")
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
	 * @return the optionOneVal
	 */
	@Column(name="option1Val")
	public String getOptionOneVal() {
		return optionOneVal;
	}
	/**
	 * @param optionOneVal the optionOneVal to set
	 */
	public void setOptionOneVal(String optionOneVal) {
		this.optionOneVal = optionOneVal;
	}
	/**
	 * @return the optionTwoVal
	 */
	@Column(name="option2Val")
	public String getOptionTwoVal() {
		return optionTwoVal;
	}
	/**
	 * @param optionTwoVal the optionTwoVal to set
	 */
	public void setOptionTwoVal(String optionTwoVal) {
		this.optionTwoVal = optionTwoVal;
	}
	/**
	 * @return the optionThreeVal
	 */
	@Column(name="option3Val")
	public String getOptionThreeVal() {
		return optionThreeVal;
	}
	/**
	 * @param optionThreeVal the optionThreeVal to set
	 */
	public void setOptionThreeVal(String optionThreeVal) {
		this.optionThreeVal = optionThreeVal;
	}
	/**
	 * @return the optionFourVal
	 */
	@Column(name="option4Val")
	public String getOptionFourVal() {
		return optionFourVal;
	}
	/**
	 * @param optionFourVal the optionFourVal to set
	 */
	public void setOptionFourVal(String optionFourVal) {
		this.optionFourVal = optionFourVal;
	}
	/**
	 * @return the optionFiveVal
	 */
	@Column(name="option5Val")
	public String getOptionFiveVal() {
		return optionFiveVal;
	}
	/**
	 * @param optionFiveVal the optionFiveVal to set
	 */
	public void setOptionFiveVal(String optionFiveVal) {
		this.optionFiveVal = optionFiveVal;
	}
	
	
}
