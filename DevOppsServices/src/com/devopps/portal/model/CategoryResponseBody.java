package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"categoryDetails","statusMsg","categoryId"})
		
@XmlRootElement(name = "details")
public class CategoryResponseBody {

	private List<AssessmentCategoryDetails> categoryDetails;
	private String statusMsg;
	private int categoryId;
	
	
	/**
	 * @return the categoryDetails
	 */
	public List<AssessmentCategoryDetails> getCategoryDetails() {
		return categoryDetails;
	}
	/**
	 * @param categoryDetails the categoryDetails to set
	 */
	public void setCategoryDetails(List<AssessmentCategoryDetails> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
	/**
	 * @return the statusMsg
	 */
	public String getStatusMsg() {
		return statusMsg;
	}
	/**
	 * @param statusMsg the statusMsg to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
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
	
	
	
	
}
