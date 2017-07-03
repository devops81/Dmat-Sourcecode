package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;

public class SubCategoryResponseHeader {
	
	private String statusCode;
	private String statusDesc;
	private String operationName;
	/**
	 * @return the statusCode
	 */
	@XmlElement(name="statusCode")
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the statusDesc
	 */
	@XmlElement(name="statusDesc")
	public String getStatusDesc() {
		return statusDesc;
	}
	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	/**
	 * @return the operationName
	 */
	@XmlElement(name="operationName")
	public String getOperationName() {
		return operationName;
	}
	/**
	 * @param operationName the operationName to set
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	
}
