package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "questionScoreResponseBody"})

public class QuestionScoreServiceResponse {
	
	private ResponseHeader responseHeader;
	private QuestionScoreResponseBody questionScoreResponseBody;
	
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
	 * @return the questionScoreResponseBody
	 */
	@XmlElement(name="detail")
	public QuestionScoreResponseBody getQuestionScoreResponseBody() {
		return questionScoreResponseBody;
	}
	/**
	 * @param questionScoreResponseBody the questionScoreResponseBody to set
	 */
	public void setQuestionScoreResponseBody(
			QuestionScoreResponseBody questionScoreResponseBody) {
		this.questionScoreResponseBody = questionScoreResponseBody;
	}
	
	
	
}
