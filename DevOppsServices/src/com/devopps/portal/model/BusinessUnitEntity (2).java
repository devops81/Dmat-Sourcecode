package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="business_unit_master")
public class BusinessUnitEntity {
	
	private int businessUnitId;
	private String businessUnitName;
	
	/**
	 * @return the businessUnitId
	 */
	@Id
	@Column(name="business_unit_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	 * @return the businessUnitName
	 */
	@Column(name="business_unit_name")
	public String getBusinessUnitName() {
		return businessUnitName;
	}
	/**
	 * @param businessUnitName the businessUnitName to set
	 */
	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}
	
}
