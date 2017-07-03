package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "userProfileResponseBody"})
public class UserProfileServiceResponse {

	private ResponseHeader responseHeader;	
	private UserProfileResponseBody userProfileResponseBody;
	
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	@XmlElement(name="details")
	public UserProfileResponseBody getUserProfileResponseBody() {
		return userProfileResponseBody;
	}
	public void setUserProfileResponseBody(
			UserProfileResponseBody userProfileResponseBody) {
		this.userProfileResponseBody = userProfileResponseBody;
	}
	
	
	
}


