package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applicationId","applicationName","businessUnitId","isActive"
})
@XmlRootElement(name = "saveApplication")
public class SaveApplicationRequestBody {
	
	@XmlElement(required = true)
	private int applicationId;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(AdapterXmlCDATA.class)
	private String applicationName;
	
	@XmlElement(required = true)
	private int businessUnitId;
	
	@XmlElement(required = true)
	private boolean isActive;

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
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName the applicationName to set
	 */
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
	 * @return the businessUnitId
	 */
	public int getBusinessUnitId() {
		return businessUnitId;
	}

	/**
	 * @param businessUnitId the businessUnitId to set
	 */
	public void setBusinessUnitId(int businessUnitId) {
		this.businessUnitId = businessUnitId;
	}
	
}
