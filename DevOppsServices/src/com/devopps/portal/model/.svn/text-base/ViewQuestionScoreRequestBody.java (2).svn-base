package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applicationId" ,"questionnaireType"
})
@XmlRootElement(name = "viewQuestionDetails")
public class ViewQuestionScoreRequestBody {

	@XmlElement(required = true)
	private int applicationId;
	
	private int questionnaireType;

	/**
	 * @return the applicationId
	 */
	public int getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the questionnaireType
	 */
	public int getQuestionnaireType() {
		return questionnaireType;
	}

	/**
	 * @param questionnaireType the questionnaireType to set
	 */
	public void setQuestionnaireType(int questionnaireType) {
		this.questionnaireType = questionnaireType;
	}

}
