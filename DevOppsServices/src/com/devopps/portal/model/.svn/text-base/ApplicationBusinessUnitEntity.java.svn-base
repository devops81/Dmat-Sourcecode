package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application_businessunit_mapping")
public class ApplicationBusinessUnitEntity {

	private int id;
	private int applicationId;
	private int businessUnitId;
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
	 * @return the applicationId
	 */
	@Column(name="application_id")
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
	 * @return the isActive
	 */
	@Column(name="active_flag")
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
