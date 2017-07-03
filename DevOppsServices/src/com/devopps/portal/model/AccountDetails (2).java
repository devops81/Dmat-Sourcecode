package com.devopps.portal.model;

public class AccountDetails {
	
	private int accountId;
	private String account; 
	private boolean isActive;
	private boolean isEditAllowed;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
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
