package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"statusMsg","applicationId"
		})
@XmlRootElement(name = "details")
public class SaveApplicationResponseBody {
	private static final long serialVersionUID = 1L;
	

	private String statusMsg;
	
	private int applicationId;
	/**
	 * @return the statusDesc
	 */
	public String getStatusMsg() {
		return statusMsg;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
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
	
	
}