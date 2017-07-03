package com.devopps.portal.service;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.model.AssessmentAreasServiceResponse;
import com.devopps.portal.model.SaveAssessmentRequestBody;
import com.devopps.portal.model.SaveAssessmentServiceResponse;


public interface IAssessmentService {

	public AssessmentAreasServiceResponse getAssessmentAreas (Boolean isMappingRequired);
	public SaveAssessmentServiceResponse saveAssessmentArea(SaveAssessmentRequestBody saveAssessmentRequestBody) throws DuplicateAreasException;

	
	
}
