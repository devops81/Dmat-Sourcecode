package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IQuestionScoreDao;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.FeedbackFormDetails;
import com.devopps.portal.model.FeedbackFormRequest;
import com.devopps.portal.model.FormFeedbackResponseBody;
import com.devopps.portal.model.FormFeedbackServiceResponse;
import com.devopps.portal.model.QuestionResponseDetails;
import com.devopps.portal.model.QuestionScoreResponseBody;
import com.devopps.portal.model.QuestionScoreServiceResponse;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveQuestionScoreRequest;
import com.devopps.portal.model.ViewQuestionScoreRequestBody;
import com.devopps.portal.model.ViewQuestionScoreResponse;
import com.devopps.portal.model.ViewQuestionScoreResponseBody;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IQuestionScoreService")
public class QuestionScoreServiceImpl implements IQuestionScoreService{
	
	@Autowired
	@Qualifier("IQuestionScoreDao")
	IQuestionScoreDao questionScoreDao;
	
	@Override
	public ViewQuestionScoreResponse getQuestionScoreResponse(ViewQuestionScoreRequestBody viewQuestionScoreRequestBody) {
		List<QuestionResponseDetails> questionResponseDetails = null;
		try {
			questionResponseDetails = questionScoreDao.getQuestionScoreResponse(viewQuestionScoreRequestBody);
			
		}  catch (HibernateException ex) {
		 	ExceptionHandler.handle(ex);
			return buildQuestionScoreResponse(questionResponseDetails, IStatusCodeConstants.STATUS_FAILURE, IStatusCodeConstants.FAILURE_DESC);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return buildQuestionScoreResponse(questionResponseDetails, IStatusCodeConstants.STATUS_FAILURE, IStatusCodeConstants.FAILURE_DESC);
		}
		return buildQuestionScoreResponse(questionResponseDetails, IStatusCodeConstants.STATUS_SUCCESS, IStatusCodeConstants.SUCCESS_DESC);
	}


	@Override
	public QuestionScoreServiceResponse saveQuestionScore(SaveQuestionScoreRequest questionScoreRequest) {
		try {
			 questionScoreDao.saveQuestionScore(questionScoreRequest);
		} catch (HibernateException hex) {
		 	ExceptionHandler.handle(hex);
			return saveScoreResponse(IConstants.FAILURE,  IStatusCodeConstants.STATUS_FAILURE);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return saveScoreResponse(IConstants.FAILURE,  IStatusCodeConstants.STATUS_FAILURE);
		}
		return saveScoreResponse(IConstants.SUCCESS, IStatusCodeConstants.STATUS_SUCCESS);
	}


	private QuestionScoreServiceResponse saveScoreResponse(String statusDesc , String statusCode) {
		QuestionScoreServiceResponse questionScoreServiceResponse = new QuestionScoreServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		QuestionScoreResponseBody questionScoreResponseBody = new QuestionScoreResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.SAVE_QUESTION_SCORE);
		questionScoreResponseBody.setStatusMsg(statusDesc);
		questionScoreServiceResponse.setResponseHeader(responseHeader);
		questionScoreServiceResponse.setQuestionScoreResponseBody(questionScoreResponseBody);
		return questionScoreServiceResponse;
	}
	
	private ViewQuestionScoreResponse buildQuestionScoreResponse(List<QuestionResponseDetails> questionResponseDetails, String statusCode, String statusDesc) {
		ViewQuestionScoreResponse viewQuestionScoreResponse = new ViewQuestionScoreResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		ViewQuestionScoreResponseBody viewQuestionScoreResponseBody = new ViewQuestionScoreResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.VIEW_QUESTION_REPORT);
		viewQuestionScoreResponseBody.setQuestionResponseDetails(questionResponseDetails);
		viewQuestionScoreResponseBody.setStatusMsg(statusDesc);
		viewQuestionScoreResponse.setResponseHeader(responseHeader);
		viewQuestionScoreResponse.setViewQuestionScoreResponseBody(viewQuestionScoreResponseBody);
		return viewQuestionScoreResponse;
		
	}


	@Override
	public FormFeedbackServiceResponse handleFormFeedback(
			FeedbackFormRequest feedbackFormRequest) {
		int feedbackId = -1;
		List<FeedbackFormDetails> feedbackDetails = null;
		try {
			 if (feedbackFormRequest.isViewOnly()) {
				 feedbackDetails = questionScoreDao.viewFreeFormFeedback(feedbackFormRequest);
			 } else {
				 feedbackId = questionScoreDao.saveFreeFormFeedback(feedbackFormRequest);
			 }
		}
		catch (HibernateException hex) {
		 	ExceptionHandler.handle(hex);
			return saveFeedbackResponse(feedbackDetails, feedbackId, IConstants.FAILURE,  IStatusCodeConstants.STATUS_FAILURE);
		} catch (NoRecordsFoundException nfe) {
		 	ExceptionHandler.handle(nfe);
			return saveFeedbackResponse(feedbackDetails, feedbackId, IConstants.FAILURE,  IStatusCodeConstants.STATUS_FAILURE);
		}	catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return saveFeedbackResponse(feedbackDetails, feedbackId, IConstants.FAILURE,  IStatusCodeConstants.STATUS_FAILURE);
		}
		return saveFeedbackResponse(feedbackDetails, feedbackId, IConstants.SUCCESS, IStatusCodeConstants.STATUS_SUCCESS);
	}
	
	private FormFeedbackServiceResponse saveFeedbackResponse(List<FeedbackFormDetails> feedbackDetails, int feedbackId, String statusDesc , String statusCode) {
		FormFeedbackServiceResponse formFeedbackServiceResponse = new FormFeedbackServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		FormFeedbackResponseBody formFeedbackResponseBody = new FormFeedbackResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.SAVE_VIEW_FREE_FORM_FEEDBACK);
		formFeedbackResponseBody.setFeedbackId(feedbackId);
		formFeedbackResponseBody.setStatusMsg(statusDesc);
		formFeedbackResponseBody.setFeedbackDetails(feedbackDetails);
		formFeedbackServiceResponse.setResponseHeader(responseHeader);
		formFeedbackServiceResponse.setFormFeedbackResponseBody(formFeedbackResponseBody);
		return formFeedbackServiceResponse;
	}
}
