package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AssessmentEntity;
import com.devopps.portal.model.SaveAssessmentRequestBody;


public interface IAssessmentAreasDao {

	List<AssessmentEntity> getAssessmentAreas();
	void setAssessmentArea(SaveAssessmentRequestBody saveAssessmentRequestBody) throws DuplicateAreasException, NoRecordsFoundException;
}
