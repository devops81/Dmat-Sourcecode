package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"assessmentAreasResponseHeader", "assessmentAreasResponseBody"})
public class AssessmentAreasServiceResponse {
	private ResponseHeader assessmentAreasResponseHeader;
	private AssessmentAreasResponseBody assessmentAreasResponseBody;
	
	
	/**
	 * @return the assessmentAreasResponseHeader
	 */
	@XmlElement(name="header")
	public ResponseHeader getAssessmentAreasResponseHeader() {
		return assessmentAreasResponseHeader;
	}
	/**
	 * @param assessmentAreasResponseHeader the assessmentAreasResponseHeader to set
	 */
	public void setAssessmentAreasResponseHeader(
			ResponseHeader assessmentAreasResponseHeader) {
		this.assessmentAreasResponseHeader = assessmentAreasResponseHeader;
	}
	/**
	 * @return the assessmentAreasResponseBody
	 */
	@XmlElement(name="detail")
	public AssessmentAreasResponseBody getAssessmentAreasResponseBody() {
		return assessmentAreasResponseBody;
	}
	/**
	 * @param assessmentAreasResponseBody the assessmentAreasResponseBody to set
	 */
	public void setAssessmentAreasResponseBody(
			AssessmentAreasResponseBody assessmentAreasResponseBody) {
		this.assessmentAreasResponseBody = assessmentAreasResponseBody;
	}
	
	
}
