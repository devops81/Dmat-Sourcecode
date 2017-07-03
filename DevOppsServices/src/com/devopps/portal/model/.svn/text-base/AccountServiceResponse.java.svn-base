package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "accountResponseBody"})
public class AccountServiceResponse {
	
	private ResponseHeader responseHeader;	
	private AccountResponseBody accountResponseBody;
	
	@XmlElement(name="header")
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	
	@XmlElement(name="details")
	public AccountResponseBody getAccountResponseBody() {
		return accountResponseBody;
	}
	public void setAccountResponseBody(AccountResponseBody accountResponseBody) {
		this.accountResponseBody = accountResponseBody;
	}
}
