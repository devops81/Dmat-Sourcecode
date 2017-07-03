package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IApplicationDao;
import com.devopps.portal.dao.IDisplayDao;
import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.ApplicationDetails;
import com.devopps.portal.model.ApplicationResponseBody;
import com.devopps.portal.model.ApplicationServiceResponse;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.model.SaveApplicationResponseBody;
import com.devopps.portal.model.SaveApplicationResponseHeader;
import com.devopps.portal.model.SaveApplicationServiceResponse;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IApplicationService")
public class ApplicationServiceImpl implements IApplicationService {

	@Autowired
	@Qualifier("IApplicationDao")
	IApplicationDao applicationDao;
	
	@Autowired
	@Qualifier("IDisplayDao")
	IDisplayDao displayDao;
	
	@Override
	public SaveApplicationServiceResponse saveApplication(SaveApplicationRequestBody saveApplicationRequestBody) {
		SaveApplicationServiceResponse response = new SaveApplicationServiceResponse();
		int applicationId = -1;
		try {
			applicationId = applicationDao.saveApplication(saveApplicationRequestBody);
		 } catch (HibernateException ex) {
			ExceptionHandler.handle(ex);
			return saveApplicationReponse(applicationId , IStatusCodeConstants.STATUS_FAILURE,IConstants.FAILURE);
		} catch (DuplicateAreasException dx) {
			ExceptionHandler.handle(dx);
			return saveApplicationReponse(applicationId , IStatusCodeConstants.STATUS_DUPLICATE,IConstants.DUPLICATE_AREA);
		} catch (NoRecordsFoundException nx) {
			ExceptionHandler.handle(nx);
			return saveApplicationReponse(applicationId , IStatusCodeConstants.NO_RECORDS_FOUND,IConstants.NO_RECORDS_FOUND);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return saveApplicationReponse(applicationId , IStatusCodeConstants.STATUS_FAILURE,IConstants.FAILURE);
		}
		response = saveApplicationReponse(applicationId , IStatusCodeConstants.STATUS_SUCCESS,IConstants.SUCCESS);
		return response;
	}
	
	
	@Override
	public ApplicationServiceResponse getApplicationDetails() {
		
		ApplicationServiceResponse response = new ApplicationServiceResponse();
		List<ApplicationDetails>  appDetails = null;
		try {
			appDetails = displayDao.getApplicationDetails();
		} catch (HibernateException ex) {
		 	ExceptionHandler.handle(ex);
			return getApplicationsReponse(appDetails, IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return getApplicationsReponse(appDetails, IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE);
		}
		response = getApplicationsReponse(appDetails, IStatusCodeConstants.STATUS_SUCCESS, IConstants.SUCCESS);
		return response;
		
	}
	

	private ApplicationServiceResponse getApplicationsReponse(List<ApplicationDetails> appDetails, String statusCode, String statusDesc) {
		ApplicationServiceResponse response = new ApplicationServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		ApplicationResponseBody responseBody = new ApplicationResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.DISPLAY_APPLICATION);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setApplicationDetails(appDetails);
		response.setResponseHeader(responseHeader);
		response.setApplicationResponseBody(responseBody);
		return response;
	}
	
	private SaveApplicationServiceResponse saveApplicationReponse(int applicationId, String statusCode, String statusDesc) {
		SaveApplicationServiceResponse response = new SaveApplicationServiceResponse();
		SaveApplicationResponseHeader responseHeader = new SaveApplicationResponseHeader();
		SaveApplicationResponseBody responseBody = new SaveApplicationResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.SAVE_APPLICATION);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setApplicationId(applicationId);
		response.setSaveApplicationResponseHeader(responseHeader);
		response.setSaveApplicationResponseBody(responseBody);
		return response;
	}
	
	
}
