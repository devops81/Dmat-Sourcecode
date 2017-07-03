package com.devopps.portal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "questionScoreInfo" , "userType"
})
@XmlRootElement(name = "saveQuestionScore")
public class SaveQuestionScoreRequest {
	
	@XmlElement(required = true)
	private List<QuestionInputScore> questionScoreInfo;
	private String userType;

	/**
	 * @return the questionScoreInfo
	 */
	public List<QuestionInputScore> getQuestionScoreInfo() {
		return questionScoreInfo;
	}

	/**
	 * @param questionScoreInfo the questionScoreInfo to set
	 */
	public void setQuestionScoreInfo(List<QuestionInputScore> questionScoreInfo) {
		this.questionScoreInfo = questionScoreInfo;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	
}
