package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = { "loginResponseHeader", "loginResponseBody"})
public class LoginStatusServiceResponse {

	private LoginStatusServiceResponseHeader loginResponseHeader;
	private LoginStatusServiceResponseBody loginResponseBody;
	/**
	 * @return the loginResponseHeader
	 */
	@XmlElement(name="header")
	public LoginStatusServiceResponseHeader getLoginResponseHeader() {
		return loginResponseHeader;
	}
	/**
	 * @param loginResponseHeader the loginResponseHeader to set
	 */
	public void setLoginResponseHeader(
			LoginStatusServiceResponseHeader loginResponseHeader) {
		this.loginResponseHeader = loginResponseHeader;
	}
	/**
	 * @return the loginResponseBody
	 */
	@XmlElement(name="detail")
	public LoginStatusServiceResponseBody getLoginResponseBody() {
		return loginResponseBody;
	}
	/**
	 * @param loginResponseBody the loginResponseBody to set
	 */
	public void setLoginResponseBody(
			LoginStatusServiceResponseBody loginResponseBody) {
		this.loginResponseBody = loginResponseBody;
	}
	
	
	
	
}
