package com.devopps.portal.model;

import java.util.List;

public class SaveApplicationServiceRequest {
	
	private String userId;
	private List<String> applicationIds;
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the applicationIds
	 */
	public List<String> getApplicationIds() {
		return applicationIds;
	}
	/**
	 * @param applicationIds the applicationIds to set
	 */
	public void setApplicationIds(List<String> applicationIds) {
		this.applicationIds = applicationIds;
	}
	
	
	
	
}
