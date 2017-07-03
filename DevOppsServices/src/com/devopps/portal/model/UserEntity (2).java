package com.devopps.portal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_Details")
public class UserEntity {
	
	private int id;
	
	private String name;
	
	private String businessUnit;
	@OneToMany(mappedBy="application_master")
	private List<ApplicationEntity> applications;
	
	public List<ApplicationEntity> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationEntity> applications) {
		this.applications = applications;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="businessUnit")
	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", businessUnit="+businessUnit;
	}

}
