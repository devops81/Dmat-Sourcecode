package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"userProfileDetails","statusMsg"})
		
@XmlRootElement(name = "details")


public class UserProfileResponseBody {
	
	private List<UserProfileDetails> userProfileDetails;
	private String statusMsg;
	
	
	
	public List<UserProfileDetails> getUserProfileDetails() {
		return userProfileDetails;
	}
	public void setUserProfileDetails(List<UserProfileDetails> userProfileDetails) {
		this.userProfileDetails = userProfileDetails;
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

