package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"questionResponseDetails","statusMsg"
})
		
@XmlRootElement(name = "details")
public class ViewQuestionScoreResponseBody {
	
	private List<QuestionResponseDetails> questionResponseDetails;
	private String statusMsg;
	
	/**
	 * @return the questionResponseDetails
	 */
	public List<QuestionResponseDetails> getQuestionResponseDetails() {
		return questionResponseDetails;
	}
	/**
	 * @param questionResponseDetails the questionResponseDetails to set
	 */
	public void setQuestionResponseDetails(
			List<QuestionResponseDetails> questionResponseDetails) {
		this.questionResponseDetails = questionResponseDetails;
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
	
	
	
}
