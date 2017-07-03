package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isViewOnly",
    "saveOrUpdate",
    "roleId",
    "roleName",
    "isActive"
})
@XmlRootElement(name = "role")
public class AddRolesRequestBody {
	
	private boolean isViewOnly;
	private int saveOrUpdate;
	private int roleId;
	private String roleName;
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	
	
}
