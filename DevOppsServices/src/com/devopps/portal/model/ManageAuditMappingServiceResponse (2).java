package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "manageAuditMappingResponseBody"})
public class ManageAuditMappingServiceResponse {
	
	private ResponseHeader responseHeader;
	private ManageAuditMappingResponseBody manageAuditMappingResponseBody;
	/**
	 * @return the responseHeader
	 */
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	/**
	 * @param responseHeader the responseHeader to set
	 */
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	/**
	 * @return the manageAuditMappingResponseBody
	 */
	public ManageAuditMappingResponseBody getManageAuditMappingResponseBody() {
		return manageAuditMappingResponseBody;
	}
	/**
	 * @param manageAuditMappingResponseBody the manageAuditMappingResponseBody to set
	 */
	public void setManageAuditMappingResponseBody(
			ManageAuditMappingResponseBody manageAuditMappingResponseBody) {
		this.manageAuditMappingResponseBody = manageAuditMappingResponseBody;
	}
	
	
	

}
