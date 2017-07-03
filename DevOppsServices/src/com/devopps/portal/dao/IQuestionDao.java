package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.model.ISaveQuestionServiceParameters;
import com.devopps.portal.model.QuestionDetails;
import com.devopps.portal.model.SaveQuestionRequestBody;


public interface IQuestionDao {

	int saveQuestion(SaveQuestionRequestBody saveQuestionRequestBody);
	List<QuestionDetails> getQuestionDetails(int questionnaireType);
}
