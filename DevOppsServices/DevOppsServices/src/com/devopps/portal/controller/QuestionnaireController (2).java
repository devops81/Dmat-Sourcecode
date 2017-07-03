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

import com.devopps.portal.model.QuestionServiceResponse;
import com.devopps.portal.model.SaveQuestionRequestBody;
import com.devopps.portal.model.ViewQuestionnaireResponse;
import com.devopps.portal.service.IQuestionService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController extends AbstractController {
	
	@Autowired
	@Qualifier("IQuestionService")
	IQuestionService questionService;
	
	
	private static final Log LOGGER = LogFactory.getLog(QuestionnaireController.class);
	
	/**
	 * http://localhost:8080/DevOppsServices/questionnaire/viewQuestionnaire/1.0
	 * 
	 * 
	 */
	@RequestMapping(value="viewQuestionnaire/{version}",method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String viewQuestionnaire(HttpServletRequest request,@PathVariable Integer version) {
		LOGGER.debug("[viewQuestionnaire()] Service :: Start");
		ViewQuestionnaireResponse viewQuestionnaireResponse = null;
		String jsonResponse = null;
		viewQuestionnaireResponse = questionService.getQuestionDetails();
		LOGGER.debug("[viewQuestionnaire()] :: Ends :: Response -> "+viewQuestionnaireResponse);
		String stringXML = marshal(viewQuestionnaireResponse);
		jsonResponse = convertXMlToJson(stringXML);
		return jsonResponse;
	}
	
	
	/*
	 * http://localhost:8080/DevOppsServices/questionnaire/saveQuestionnaire/1.0
	 * <saveUpdateQuestion>
	 * <questionnaireType>1</questionnaireType>
  		<assessmentId>3</assessmentId>
  		<categoryId>29</categoryId>
  		<subCategoryId>10</subCategoryId>
 		<questionId>-1</questionId>
		<questionText>Are you opting for correct solution</questionText>
		<optionOne>Yes</optionOne>
		<optionTwo>No</optionTwo>
		<optionThree>May be</optionThree>
		<optionFour>Cant Say</optionFour>
		<optionFive>Sure</optionFive>
		<isActive>true</isActive>
		<applicationId>1</applicationId>
		<businessUnitId>-1</businessUnitId>
		<reportId>1</reportId>
		</saveUpdateQuestion>

	 */
	@RequestMapping(value = "saveQuestionnaire/{version}",method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String saveQuestion(HttpServletRequest request,@RequestBody SaveQuestionRequestBody saveQuestionRequestBody) {
		LOGGER.debug("[saveQuestion] Service :: Start");
		QuestionServiceResponse questionServiceResponse = null;
		String jsonResponse = null;
		questionServiceResponse = questionService.saveQuestion(saveQuestionRequestBody);
		LOGGER.debug("[saveQuestion()] :: Ends :: Response -> "+questionServiceResponse);
		String stringXML = marshal(questionServiceResponse);
		jsonResponse = convertXMlToJson(stringXML);
		return jsonResponse;
	}
	
}
