package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"assessmentAreaList","statusMsg"})
		
@XmlRootElement(name = "details")
public class AssessmentAreasResponseBody {
	private static final long serialVersionUID = 1L;

	private List<AssessmentApplicationDetails> assessmentAreaList;
	private String statusMsg;
	
	/**
	 * @return the assessmentAreaList
	 */
	public List<AssessmentApplicationDetails> getAssessmentAreaList() {
		return assessmentAreaList;
	}
	/**
	 * @param assessmentAreaList the assessmentAreaList to set
	 */
	public void setAssessmentAreaList(List<AssessmentApplicationDetails> assessmentAreaList) {
		this.assessmentAreaList = assessmentAreaList;
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
