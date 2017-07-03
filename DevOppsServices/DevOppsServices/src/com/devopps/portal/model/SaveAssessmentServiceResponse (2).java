package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"saveAssessmentResponseHeader", "saveAssessmentResponseBody"})
public class SaveAssessmentServiceResponse {
	
	private ResponseHeader saveAssessmentResponseHeader;
	private SaveAssessmentResponseBody saveAssessmentResponseBody;
	
	/**
	 * @return the saveAssessmentResponseHeader
	 */
	@XmlElement(name="header")
	public ResponseHeader getSaveAssessmentResponseHeader() {
		return saveAssessmentResponseHeader;
	}
	/**
	 * @param saveAssessmentResponseHeader the saveAssessmentResponseHeader to set
	 */
	public void setSaveAssessmentResponseHeader(
			ResponseHeader saveAssessmentResponseHeader) {
		this.saveAssessmentResponseHeader = saveAssessmentResponseHeader;
	}
	/**
	 * @return the saveAssessmentResponseBody
	 */
	@XmlElement(name="detail")
	public SaveAssessmentResponseBody getSaveAssessmentResponseBody() {
		return saveAssessmentResponseBody;
	}
	/**
	 * @param saveAssessmentResponseBody the saveAssessmentResponseBody to set
	 */
	public void setSaveAssessmentResponseBody(
			SaveAssessmentResponseBody saveAssessmentResponseBody) {
		this.saveAssessmentResponseBody = saveAssessmentResponseBody;
	}
}
