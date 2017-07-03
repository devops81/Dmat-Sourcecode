package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"statusMsg","feedbackId","feedbackDetails"})
		
@XmlRootElement(name = "details")
public class FormFeedbackResponseBody {
	
	private int feedbackId;
	private String statusMsg;
	private List<FeedbackFormDetails> feedbackDetails;
	
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
	 * @return the feedbackDetails
	 */
	public List<FeedbackFormDetails> getFeedbackDetails() {
		return feedbackDetails;
	}
	/**
	 * @param feedbackDetails the feedbackDetails to set
	 */
	public void setFeedbackDetails(List<FeedbackFormDetails> feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}
	

}
