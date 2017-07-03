package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "viewQuestionResponseBody"})
public class ViewQuestionnaireResponse {
	
	private ResponseHeader responseHeader;	
	private ViewQuestionResponseBody viewQuestionResponseBody;
	
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
	 * @return the viewQuestionResponseBody
	 */
	@XmlElement(name="detail")
	public ViewQuestionResponseBody getViewQuestionResponseBody() {
		return viewQuestionResponseBody;
	}
	/**
	 * @param viewQuestionResponseBody the viewQuestionResponseBody to set
	 */
	public void setViewQuestionResponseBody(
			ViewQuestionResponseBody viewQuestionResponseBody) {
		this.viewQuestionResponseBody = viewQuestionResponseBody;
	}
	
}
