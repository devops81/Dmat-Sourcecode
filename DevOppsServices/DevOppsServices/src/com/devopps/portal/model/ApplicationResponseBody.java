package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "", propOrder = {
		"applicationDetails","statusMsg"})
@XmlRootElement(name = "details")

public class ApplicationResponseBody {
	
	private List<ApplicationDetails> applicationDetails;
	private String statusMsg;
	
	
	public List<ApplicationDetails> getApplicationDetails() {
		return applicationDetails;
	}
	public void setApplicationDetails(List<ApplicationDetails> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
}
