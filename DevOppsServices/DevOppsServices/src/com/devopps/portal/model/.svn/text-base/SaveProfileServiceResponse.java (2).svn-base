package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "saveProfileResponseBody"})
public class SaveProfileServiceResponse {
	
	private ResponseHeader responseHeader;	
	private SaveProfileResponseBody saveProfileResponseBody;
	
	
	@XmlElement(name="header")
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	
	@XmlElement(name="details")
	public SaveProfileResponseBody getSaveProfileResponseBody() {
		return saveProfileResponseBody;
	}
	public void setSaveProfileResponseBody(
			SaveProfileResponseBody saveProfileResponseBody) {
		this.saveProfileResponseBody = saveProfileResponseBody;
	}
	
	

	
	

}