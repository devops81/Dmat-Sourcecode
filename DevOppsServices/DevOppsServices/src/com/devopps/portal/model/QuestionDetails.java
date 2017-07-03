package com.devopps.portal.model;

public class QuestionDetails {
	
	private int questionId;
	private int assessmentId;
	private String assessmentArea;
	private int categoryId;
	private String category;
	private int subcategoryId;
	private String subCategory;
	private String questionName;
	private String optionOneVal;
	private String optionTwoVal;
	private String optionThreeVal;
	private String optionFourVal;
	private String optionFiveVal;
	private boolean isActive;
	/**
	 * @return the questionId
	 */
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
	 * @return the assessmentArea
	 */
	public String getAssessmentArea() {
		return assessmentArea;
	}
	/**
	 * @param assessmentArea the assessmentArea to set
	 */
	public void setAssessmentArea(String assessmentArea) {
		this.assessmentArea = assessmentArea;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}
	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	/**
	 * @return the questionName
	 */
	public String getQuestionName() {
		return questionName;
	}
	/**
	 * @param questionName the questionName to set
	 */
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
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
	 * @return the subcategoryId
	 */
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
