package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "roleResponseBody"})
public class RoleServiceResponse {
	
	private ResponseHeader responseHeader;	
	private RoleResponseBody roleResponseBody;
	
	/**
	 * @return the responseHeader
	 */
	@XmlElement(name="header")
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	/**
	 * @param responseHeader the responseHeader to set
	 */
	public void setResponseHeader(
			ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	/**
	 * @return the roleResponseBody
	 */
	@XmlElement(name="details")
	public RoleResponseBody getRoleResponseBody() {
		return roleResponseBody;
	}
	/**
	 * @param roleResponseBody the roleResponseBody to set
	 */
	public void setRoleResponseBody(
			RoleResponseBody roleResponseBody) {
		this.roleResponseBody = roleResponseBody;
	}

	
	

}
