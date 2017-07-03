package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IAssessmentAreasDao;
import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AssessmentAreasResponseBody;
import com.devopps.portal.model.AssessmentAreasServiceResponse;
import com.devopps.portal.model.AssessmentEntity;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveAssessmentRequestBody;
import com.devopps.portal.model.SaveAssessmentResponseBody;
import com.devopps.portal.model.SaveAssessmentServiceResponse;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IAssessmentService")
public class AssessmentServiceImpl implements IAssessmentService{

	@Autowired
	@Qualifier("IAssessmentAreasDao")
	IAssessmentAreasDao assessmentAreasDao;
	
	@Override
	public AssessmentAreasServiceResponse getAssessmentAreas() {
		AssessmentAreasServiceResponse response = new AssessmentAreasServiceResponse();
		List<AssessmentEntity>  assessmentAreaDetails = null;
		try {
			assessmentAreaDetails = assessmentAreasDao.getAssessmentAreas();
		}  catch (HibernateException ex) {
			ExceptionHandler.handle(ex);
			return buildAssessmentAreasResponse(assessmentAreaDetails, IConstants.FAILURE_MESSAGE,IStatusCodeConstants.STATUS_FAILURE );
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return buildAssessmentAreasResponse(assessmentAreaDetails, IConstants.FAILURE_MESSAGE,IStatusCodeConstants.STATUS_FAILURE);
		}
		response = buildAssessmentAreasResponse(assessmentAreaDetails,IConstants.SUCCESS_MESSAGE, IStatusCodeConstants.STATUS_SUCCESS );
		return response;
		
	}
	
	@Override
	public SaveAssessmentServiceResponse saveAssessmentArea(SaveAssessmentRequestBody saveAssessmentRequestBody) throws DuplicateAreasException {
		SaveAssessmentServiceResponse response = new SaveAssessmentServiceResponse();
		try {
			assessmentAreasDao.setAssessmentArea(saveAssessmentRequestBody);
		}  catch (HibernateException ex) {
			ExceptionHandler.handle(ex);
			return buildSaveAssessmentResponse(IConstants.FAILURE_MESSAGE,IStatusCodeConstants.STATUS_FAILURE);
		} catch (DuplicateAreasException dpe) {
			ExceptionHandler.handle(dpe);
			return buildSaveAssessmentResponse(IConstants.DUPLICATE_AREA, IStatusCodeConstants.STATUS_DUPLICATE);
		} catch (NoRecordsFoundException nfx) {
			ExceptionHandler.handle(nfx);
			return buildSaveAssessmentResponse(IConstants.NO_RECORDS_FOUND, IStatusCodeConstants.NO_RECORDS_FOUND);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return buildSaveAssessmentResponse(IConstants.FAILURE_MESSAGE, IStatusCodeConstants.STATUS_FAILURE);
		}
		response = buildSaveAssessmentResponse(IConstants.SAVE_ASSESSMENT_SUCCESS , IStatusCodeConstants.STATUS_SUCCESS);
		return response;
		
	}
	
	private AssessmentAreasServiceResponse buildAssessmentAreasResponse(List<AssessmentEntity>  assessmentAreaDetails, String statusDesc, String statusCode) {
		AssessmentAreasServiceResponse response = new AssessmentAreasServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		AssessmentAreasResponseBody responseBody = new AssessmentAreasResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.GET_ASSESSMENT);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setAssessmentAreaList(assessmentAreaDetails);
		response.setAssessmentAreasResponseHeader(responseHeader);
		response.setAssessmentAreasResponseBody(responseBody);
		return response;
	}
	
	
	private SaveAssessmentServiceResponse buildSaveAssessmentResponse(String  statusDesc, String statusCode) {
		SaveAssessmentServiceResponse response = new SaveAssessmentServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		SaveAssessmentResponseBody responseBody = new SaveAssessmentResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.SAVE_ASSESSMENT);
		responseBody.setStatusMsg(statusDesc);
		response.setSaveAssessmentResponseHeader(responseHeader);
		response.setSaveAssessmentResponseBody(responseBody);
		return response;
	}
	
}
