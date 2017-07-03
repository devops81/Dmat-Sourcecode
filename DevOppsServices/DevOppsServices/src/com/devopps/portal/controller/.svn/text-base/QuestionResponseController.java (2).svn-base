package com.devopps.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopps.portal.model.FeedbackFormRequest;
import com.devopps.portal.model.FormFeedbackServiceResponse;
import com.devopps.portal.model.QuestionScoreServiceResponse;
import com.devopps.portal.model.SaveQuestionScoreRequest;
import com.devopps.portal.model.ViewQuestionScoreRequestBody;
import com.devopps.portal.model.ViewQuestionScoreResponse;
import com.devopps.portal.service.IQuestionScoreService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/questionResponse")
public class QuestionResponseController extends AbstractController {
	
	@Autowired
	@Qualifier("IQuestionScoreService")
	IQuestionScoreService questionScoreService;
	
	
	private static final Log LOGGER = LogFactory.getLog(QuestionResponseController.class);
	
	/**
	 * URL : http://localhost:8080/DevOppsServices/questionResponse/viewQuestionResponse/1.0
	 * @param request
	 * @param version
	 * @return
	 */
	@RequestMapping(value="viewQuestionResponse/{version}",method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String viewQuestionScoreResponse(HttpServletRequest request,@PathVariable Integer version, @RequestBody ViewQuestionScoreRequestBody viewQuestionScoreRequestBody) {
		LOGGER.debug("[viewQuestionResponse()] Service :: Start");
		ViewQuestionScoreResponse viewQuestionScoreResponse = null;
		viewQuestionScoreResponse = questionScoreService.getQuestionScoreResponse(viewQuestionScoreRequestBody);
		LOGGER.debug("[viewQuestionResponse()] :: Ends :: Response -> "+viewQuestionScoreResponse);
		String stringXML = marshal(viewQuestionScoreResponse);
		return convertXMlToJson(stringXML);
	}
	
	/*
	 * http://localhost:8080/DevOppsServices/questionResponse/saveQuestionScore/1.0
	 * <saveQuestionScore>
	       <questionScoreInfo>
  			<questionId>1</questionId>
 			<score>5</score>
 			<comments>hjga</comments>
 		</questionScoreInfo>
 		<questionScoreInfo>
  			<questionId>11</questionId>
 			<score>5</score>
 			<comments>esjhwkt</comments>
 		</questionScoreInfo>
 		<userTyep>admin</userType>
	   </saveQuestionScore>
	 */
	@RequestMapping(value="saveQuestionScore/{version}",method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String saveQuestionScore(HttpServletRequest request,@PathVariable Integer version,@RequestBody SaveQuestionScoreRequest saveQuestionScoreRequest) {
		LOGGER.debug("[saveQuestionScore()] Service :: Start");
		QuestionScoreServiceResponse questionScoreResponse = null;
		String jsonResponse = null;
		questionScoreResponse = questionScoreService.saveQuestionScore(saveQuestionScoreRequest);
		LOGGER.debug("[saveQuestionScore()] :: Ends :: Response -> "+ questionScoreResponse);
		String stringXML = marshal(questionScoreResponse);
		jsonResponse = convertXMlToJson(stringXML);
		return jsonResponse;
	}
	
	/**
	 * http://localhost:8080/DevOppsServices/questionResponse/handleFreeFormFeedback/1.0
	 * <feedbackForm>
	 *   <feedbackId>-1</feedbackId>
	 *   <applicationId>1</applicationId>
	 *   <employeeId>40021000</employeeId>
	 *   <accountId>1</accountId>
	 *   <roleId>1</roleId>
	 *   <feedback>Good feedback</feedback>
	 *   <filePath>"D:/Files/"</filePath>
	 *   <isViewOnly>true</isViewOnly>
	 * </feedbackForm>
	 * @param request
	 * @param version
	 * @param feedbackFormRequest
	 * @return
	 */
	@RequestMapping(value="handleFreeFormFeedback/{version}",method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String handleFreeFormFeedback(HttpServletRequest request,@PathVariable Integer version,@RequestBody FeedbackFormRequest feedbackFormRequest) {
		LOGGER.debug("[saveFreeFormFeedback()] Service :: Start");
		FormFeedbackServiceResponse feedbackServiceResponse = null;
		feedbackServiceResponse = questionScoreService.handleFormFeedback(feedbackFormRequest);
		LOGGER.debug("[saveFreeFormFeedback()] :: Ends :: Response -> "+ feedbackServiceResponse);
		String stringXML = marshal(feedbackServiceResponse);
		return convertXMlToJson(stringXML);
	}
	
	
}
