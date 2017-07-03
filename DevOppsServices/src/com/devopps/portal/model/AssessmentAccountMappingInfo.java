package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountId","businessUnitId","businessNeeds", "BusinessEnvironmentComplexity","DeliveryMaturity"
})
public class AssessmentAccountMappingInfo {
	
	@XmlElement(required = true)
	private int accountId;
	
	@XmlElement(required = true)
	private int businessUnitId;
	
	@XmlElement(required = true)
	private int businessNeeds;
	
	@XmlElement(required = true)
	private int businessEnvironmentComplexity;
	
	@XmlElement(required = true)
	private int deliveryMaturity;

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
	 * @return the businessNeeds
	 */
	public int getBusinessNeeds() {
		return businessNeeds;
	}

	/**
	 * @param businessNeeds the businessNeeds to set
	 */
	public void setBusinessNeeds(int businessNeeds) {
		this.businessNeeds = businessNeeds;
	}

	/**
	 * @return the businessEnvironmentComplexity
	 */
	public int getBusinessEnvironmentComplexity() {
		return businessEnvironmentComplexity;
	}

	/**
	 * @param businessEnvironmentComplexity the businessEnvironmentComplexity to set
	 */
	public void setBusinessEnvironmentComplexity(int businessEnvironmentComplexity) {
		this.businessEnvironmentComplexity = businessEnvironmentComplexity;
	}

	/**
	 * @return the deliveryMaturity
	 */
	public int getDeliveryMaturity() {
		return deliveryMaturity;
	}

	/**
	 * @param deliveryMaturity the deliveryMaturity to set
	 */
	public void setDeliveryMaturity(int deliveryMaturity) {
		this.deliveryMaturity = deliveryMaturity;
	}

}
