package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"responseHeader", "saveQuestionResponseBody"})

public class QuestionServiceResponse {
	private ResponseHeader responseHeader;
	private SaveQuestionResponseBody saveQuestionResponseBody;

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
	 * @return the saveQuestionResponseBody
	 */
	@XmlElement(name="detail")
	public SaveQuestionResponseBody getSaveQuestionResponseBody() {
		return saveQuestionResponseBody;
	}

	/**
	 * @param saveQuestionResponseBody the saveQuestionResponseBody to set
	 */
	public void setSaveQuestionResponseBody(
			SaveQuestionResponseBody saveQuestionResponseBody) {
		this.saveQuestionResponseBody = saveQuestionResponseBody;
	}

	
	
	
	
}
