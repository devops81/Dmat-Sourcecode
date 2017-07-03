package com.devopps.portal.service;

import com.devopps.portal.model.FeedbackFormRequest;
import com.devopps.portal.model.FormFeedbackServiceResponse;
import com.devopps.portal.model.QuestionScoreServiceResponse;
import com.devopps.portal.model.SaveQuestionScoreRequest;
import com.devopps.portal.model.ViewQuestionScoreRequestBody;
import com.devopps.portal.model.ViewQuestionScoreResponse;

public interface IQuestionScoreService {
	ViewQuestionScoreResponse getQuestionScoreResponse(ViewQuestionScoreRequestBody viewQuestionScoreRequestBody);
	QuestionScoreServiceResponse saveQuestionScore(SaveQuestionScoreRequest questionScoreRequest);
	FormFeedbackServiceResponse handleFormFeedback (FeedbackFormRequest feedbackFormRequest);
}
