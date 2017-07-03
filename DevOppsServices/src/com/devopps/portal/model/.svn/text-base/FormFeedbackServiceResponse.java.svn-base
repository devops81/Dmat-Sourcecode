package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "formFeedbackResponseBody"})
public class FormFeedbackServiceResponse {
	
	private ResponseHeader responseHeader;
	private FormFeedbackResponseBody formFeedbackResponseBody;
	
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
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	/**
	 * @return the formFeedbackResponseBody
	 */
	@XmlElement(name="detail")
	public FormFeedbackResponseBody getFormFeedbackResponseBody() {
		return formFeedbackResponseBody;
	}
	/**
	 * @param formFeedbackResponseBody the formFeedbackResponseBody to set
	 */
	public void setFormFeedbackResponseBody(
			FormFeedbackResponseBody formFeedbackResponseBody) {
		this.formFeedbackResponseBody = formFeedbackResponseBody;
	}
	
}
