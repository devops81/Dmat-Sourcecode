package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"saveOrUpdate",
    "employeeId",
    "name",
    "roleId",
    "accountId",
    "password",
    "isActive",
    "save"
})
@XmlRootElement(name = "saveUpdateProfile")
public class UserProfileRequestBody {

	private int saveOrUpdate; // 1 is for save and rest is update
	private String employeeId;
	private String name;
	private int roleId;
	private int accountId;
	private String password;
	private boolean isActive;
	private int save;

	
	/**
	 * @return the saveOrUpdate
	 */
	public int getSaveOrUpdate() {
		return saveOrUpdate;
	}
	/**
	 * @param saveOrUpdate the saveOrUpdate to set
	 */
	public void setSaveOrUpdate(int saveOrUpdate) {
		this.saveOrUpdate = saveOrUpdate;
	}
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	public int getSave() {
		return save;
	}
	public void setSave(int save) {
		this.save = save;
	}
	
	
	
		
}
