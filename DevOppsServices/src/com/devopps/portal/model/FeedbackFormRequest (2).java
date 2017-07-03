package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "feedbackId","applicationId","employeeId","accountId","roleId","feedback","filePath","isViewOnly"
})
@XmlRootElement(name = "feedbackForm")
public class FeedbackFormRequest {
	
	@XmlElement(required = true)
	private int feedbackId;
	
	@XmlElement(required = true)
	private int applicationId;
	
	@XmlElement(required = true)
	private int employeeId;
	
	@XmlElement(required = true)
	private int accountId;
	
	@XmlElement(required = true)
	private int roleId;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(AdapterXmlCDATA.class)
	private String feedback;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(AdapterXmlCDATA.class)
	private String filePath;
	
	@XmlElement(required = true)
	private boolean isViewOnly;
	
	/**
	 * @return the feedbackId
	 */
	public int getFeedbackId() {
		return feedbackId;
	}
	/**
	 * @param feedbackId the feedbackId to set
	 */
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	/**
	 * @return the applicationId
	 */
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
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the accountId
	 */
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
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the isViewOnly
	 */
	public boolean isViewOnly() {
		return isViewOnly;
	}
	/**
	 * @param isViewOnly the isViewOnly to set
	 */
	public void setViewOnly(boolean isViewOnly) {
		this.isViewOnly = isViewOnly;
	}

}
