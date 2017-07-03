package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.FeedbackFormDetails;
import com.devopps.portal.model.FeedbackFormRequest;
import com.devopps.portal.model.QuestionResponseDetails;
import com.devopps.portal.model.SaveQuestionScoreRequest;
import com.devopps.portal.model.ViewQuestionScoreRequestBody;

public interface IQuestionScoreDao {
	List<QuestionResponseDetails> getQuestionScoreResponse(ViewQuestionScoreRequestBody viewQuestionScoreRequestBody) throws IllegalArgumentException, IllegalAccessException;
	void saveQuestionScore(SaveQuestionScoreRequest questionScoreRequest);
	int saveFreeFormFeedback (FeedbackFormRequest feedbackFormRequest) throws NoRecordsFoundException;
	List<FeedbackFormDetails> viewFreeFormFeedback (FeedbackFormRequest feedbackFormRequest);
}
