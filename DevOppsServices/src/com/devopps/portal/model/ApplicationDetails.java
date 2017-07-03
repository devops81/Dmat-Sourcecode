package com.devopps.portal.model;

public class ApplicationDetails {

	private int applicationId;
	private String applicationName;
	private int businessUnit;
	private String businessName;
	private boolean isActive;
	private boolean isEditAllowed;
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
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
	/**
	 * @return the businessUnit
	 */
	public int getBusinessUnit() {
		return businessUnit;
	}
	/**
	 * @param businessUnit the businessUnit to set
	 */
	public void setBusinessUnit(int businessUnit) {
		this.businessUnit = businessUnit;
	}
	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/**
	 * @return the isEditAllowed
	 */
	public boolean isEditAllowed() {
		return isEditAllowed;
	}
	/**
	 * @param isEditAllowed the isEditAllowed to set
	 */
	public void setEditAllowed(boolean isEditAllowed) {
		this.isEditAllowed = isEditAllowed;
	}

	
}
