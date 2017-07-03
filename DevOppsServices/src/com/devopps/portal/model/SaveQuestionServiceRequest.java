package com.devopps.portal.model;


public class SaveQuestionServiceRequest {

	private int assessmentId;
	private int categoryId;
	private int subCategoryId;
	private String questionText;
	private String optionOneVal;
	private String optionTwoVal;
	private String optionThreeVal;
	private String optionFourVal;
	private String optionFiveVal;
	private boolean isActive;
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
	 * @return the subCategoryId
	 */
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
	 * @return the questionText
	 */
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
	 * @return the optionOneVal
	 */
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
	public String getOptionFiveVal() {
		return optionFiveVal;
	}
	/**
	 * @param optionFiveVal the optionFiveVal to set
	 */
	public void setOptionFiveVal(String optionFiveVal) {
		this.optionFiveVal = optionFiveVal;
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
	
}
