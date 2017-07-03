package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "applicationResponseBody"})
public class ApplicationServiceResponse {

	
	private ResponseHeader responseHeader;	
	private ApplicationResponseBody applicationResponseBody;
	
	@XmlElement(name="header")
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	
	@XmlElement(name="details")
	public ApplicationResponseBody getApplicationResponseBody() {
		return applicationResponseBody;
	}
	public void setApplicationResponseBody(
			ApplicationResponseBody applicationResponseBody) {
		this.applicationResponseBody = applicationResponseBody;
	}
	
	
}

