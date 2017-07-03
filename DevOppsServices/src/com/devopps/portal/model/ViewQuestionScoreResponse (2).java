package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "viewQuestionScoreResponseBody"})
public class ViewQuestionScoreResponse {
	
	private ResponseHeader responseHeader;
	private ViewQuestionScoreResponseBody viewQuestionScoreResponseBody;
	
	
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
	 * @return the viewQuestionScoreResponseBody
	 */
	@XmlElement(name="detail")
	public ViewQuestionScoreResponseBody getViewQuestionScoreResponseBody() {
		return viewQuestionScoreResponseBody;
	}
	/**
	 * @param viewQuestionScoreResponseBody the viewQuestionScoreResponseBody to set
	 */
	public void setViewQuestionScoreResponseBody(
			ViewQuestionScoreResponseBody viewQuestionScoreResponseBody) {
		this.viewQuestionScoreResponseBody = viewQuestionScoreResponseBody;
	}
	
	
}
