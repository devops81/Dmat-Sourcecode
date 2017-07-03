package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="businessunit_account_mapping")
public class BusinessUnitAccountEntity {
	
	private int id;
	private int businessUnitId;
	private int accountId;
	private int isActive;
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the businessUnitId
	 */
	@Column(name="business_unit_id")
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
	 * @return the accountId
	 */
	@Column(name="account_id")
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
	@Column(name="isActive")
	public int getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
}
