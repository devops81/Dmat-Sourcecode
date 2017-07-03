package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IQuestionDao;
import com.devopps.portal.model.QuestionDetails;
import com.devopps.portal.model.QuestionServiceResponse;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveQuestionRequestBody;
import com.devopps.portal.model.SaveQuestionResponseBody;
import com.devopps.portal.model.ViewQuestionResponseBody;
import com.devopps.portal.model.ViewQuestionnaireResponse;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IQuestionService")
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	@Qualifier("IQuestionDao")
	IQuestionDao questionDao;
	

	@Override
	public QuestionServiceResponse saveQuestion(SaveQuestionRequestBody saveQuestionRequestBody){
		QuestionServiceResponse questionServiceResponse = new QuestionServiceResponse();
		int questionId = -1;
		try {
			questionId = questionDao.saveQuestion(saveQuestionRequestBody);
			
		}  catch (HibernateException ex) {
		 	ex.printStackTrace();
			return buildSaveQuestionResponse(questionId, IConstants.FAILURE);
		} catch (Exception ex) {
			ex.printStackTrace();
			return buildSaveQuestionResponse(questionId , IConstants.FAILURE);
		}
		questionServiceResponse = buildSaveQuestionResponse(questionId, IConstants.SUCCESS);
		return questionServiceResponse;
	}
	
	@Override
	public ViewQuestionnaireResponse getQuestionDetails(int questionnaireType) {
		ViewQuestionnaireResponse viewQuestionnaireResponse = new ViewQuestionnaireResponse();
		List<QuestionDetails> questionDetails = null;
		try {
			
			questionDetails = questionDao.getQuestionDetails(questionnaireType);
			
		} catch (HibernateException ex) {
		 	ex.printStackTrace();
			return buildViewQuestionResponse(questionDetails, IConstants.FAILURE);
		} catch (Exception ex) {
			ex.printStackTrace();
			return buildViewQuestionResponse(questionDetails, IConstants.FAILURE);
		}
		viewQuestionnaireResponse = buildViewQuestionResponse(questionDetails, IConstants.SUCCESS);
		return viewQuestionnaireResponse;
	}
	
	
	private QuestionServiceResponse buildSaveQuestionResponse(int questionId, String status) {
		
		QuestionServiceResponse response = new QuestionServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		SaveQuestionResponseBody responseBody = new SaveQuestionResponseBody();
		if (status.equals(IConstants.SUCCESS)) {
			responseHeader.setStatusCode(IStatusCodeConstants.STATUS_SUCCESS);
			responseHeader.setStatusDesc(IStatusCodeConstants.SUCCESS_DESC);
			responseHeader.setOperationName(IConstants.SAVE_QUESTION);
			responseBody.setStatusMsg(IConstants.SAVE_QUESTION_SUCCESS);
		} else {
			responseHeader.setStatusCode(IStatusCodeConstants.STATUS_FAILURE);
			responseHeader.setStatusDesc(IStatusCodeConstants.FAILURE_DESC);
			responseHeader.setOperationName(IConstants.SAVE_QUESTION);
			responseBody.setStatusMsg(IConstants.SAVE_QUESTION_FAILURE);
		}
		response.setResponseHeader(responseHeader);
		response.setSaveQuestionResponseBody(responseBody);
		return response;
	}
	
	
	private ViewQuestionnaireResponse buildViewQuestionResponse(List<QuestionDetails> questionDetails, String status) {
		ViewQuestionnaireResponse viewQuestionnaireResponse = new ViewQuestionnaireResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		ViewQuestionResponseBody responseBody = new ViewQuestionResponseBody();
		if (status.equals(IConstants.SUCCESS)) {
			responseHeader.setStatusCode(IStatusCodeConstants.STATUS_SUCCESS);
			responseHeader.setStatusDesc(IStatusCodeConstants.SUCCESS_DESC);
			responseHeader.setOperationName(IConstants.VIEW_QUESTIONNAIRE);
			responseBody.setQuestionDetails(questionDetails);
			responseBody.setStatusMsg(IConstants.VIEW_QUESTIONNAIRE_SUCCESS);
		} else {
			responseHeader.setStatusCode(IStatusCodeConstants.STATUS_FAILURE);
			responseHeader.setStatusDesc(IStatusCodeConstants.FAILURE_DESC);
			responseHeader.setOperationName(IConstants.VIEW_QUESTIONNAIRE);
			responseBody.setStatusMsg(IConstants.VIEW_QUESTIONNAIRE_FAILURE);
		}
		viewQuestionnaireResponse.setResponseHeader(responseHeader);
		viewQuestionnaireResponse.setViewQuestionResponseBody(responseBody);
		return viewQuestionnaireResponse;
		
	}
	
	
}