package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isViewOnly",
    "showDistinctBusinessUnits",
    "businessUnitId",
    "businessUnitName",
    "accountId",
    "isActive"
})
@XmlRootElement(name = "businessUnit")
public class BusinessUnitRequestBody {
	
	private boolean isViewOnly;
	private boolean showDistinctBusinessUnits;
	private int businessUnitId;
	private String businessUnitName;
	private int accountId;
	private boolean isActive;
	
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
	
	/**
	 * @return the businessUnitName
	 */
	public String getBusinessUnitName() {
		return businessUnitName;
	}
	/**
	 * @param businessUnitName the businessUnitName to set
	 */
	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
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
	/**
	 * @return the showDistinctBusinessUnits
	 */
	public boolean isShowDistinctBusinessUnits() {
		return showDistinctBusinessUnits;
	}
	/**
	 * @param showDistinctBusinessUnits the showDistinctBusinessUnits to set
	 */
	public void setShowDistinctBusinessUnits(boolean showDistinctBusinessUnits) {
		this.showDistinctBusinessUnits = showDistinctBusinessUnits;
	}
	
	
}
