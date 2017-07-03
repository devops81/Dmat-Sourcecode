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

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.model.AssessmentAreasServiceResponse;
import com.devopps.portal.model.SaveAssessmentRequestBody;
import com.devopps.portal.model.SaveAssessmentServiceResponse;
import com.devopps.portal.service.IAssessmentService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;


@RestController
@RequestMapping("/assessment")
public class AssessmentAreasController extends AbstractController {
	
	@Autowired
	@Qualifier("IAssessmentService")
	IAssessmentService assessmentService;
	private static final Log LOGGER = LogFactory.getLog(AssessmentAreasController.class);
	
	/*
	 * URL :
	 *  http://localhost:8080/DevOppsServices/assessment/getAssessmentAreas/1.0 
	 * 
	 * Response :
	 * 
	 * {"response": {
    "detail": {
        "assessmentAreaList": [
            {
                "activeFlag": 1,
                "assessmentAreaName": "Assessment Area1",
                "assessmentId": 1,
                "weightage": 12
            }
        ],
        "statusMsg": "Operation is a Success"
    },
    "header": {
        "operationName": "Get Assessment Areas",
        "statusCode": 1,
        "statusDesc": "Operation is a Success"
    }
	 */
	
	@RequestMapping(value = "/getAssessmentAreas/{version}",method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String getAssessmentAreas(HttpServletRequest request,@PathVariable Integer version) {
		LOGGER.debug("[getAssessmentAreas] Service :: Start");
		String indentedJson = null;
		AssessmentAreasServiceResponse response = null;
		response =assessmentService.getAssessmentAreas();
		LOGGER.debug("[getAssessmentAreas()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		indentedJson = convertXMlToJson (stringXML);
		LOGGER.debug(indentedJson);
		LOGGER.debug("[getAssessmentAreas] Service :: End");
		return indentedJson;
	}
	
	/*
	 * URL :
	 * http://localhost:8080/DevOppsServices/assessment/saveAssessmentAreas/1.0 
	 * 
	 * <saveAssessment>
		<assessmentId>0</assessmentId> // -1 for save, else pass assessmentId for update
		<assessmentName>Test Area6</assessmentName>
		<weightage>30</weightage>	
		<isActive>1</isActive>
	  </saveAssessment>
	  
	  Response :
	  
	  {"response": {
    "detail": {"statusMsg": "Assessment Saved Successfully"},
    "header": {
        "operationName": "Save Assessment",
        "statusCode": 1,
        "statusDesc": "Assessment Saved Successfully"
    }
}}
	  

	 */
	@RequestMapping(value = "saveAssessmentAreas/{version}", method = RequestMethod.POST,  produces = "application/xml")
	public @ResponseBody String saveAssessmentAreas(HttpServletRequest request,@PathVariable Integer version, @RequestBody(required=true) SaveAssessmentRequestBody saveAssessment) throws DuplicateAreasException {
		LOGGER.debug("[saveAssessmentArea] Service :: Start");
		SaveAssessmentServiceResponse assessmentServiceResponse = null;
		String jsonResponse = null;
		assessmentServiceResponse = assessmentService.saveAssessmentArea( saveAssessment);
		LOGGER.debug("[saveAssessmentArea()] :: Ends :: Response -> "+assessmentServiceResponse);
		String stringXML = marshal(assessmentServiceResponse);
		jsonResponse = convertXMlToJson(stringXML);
		return jsonResponse;
	}

}
