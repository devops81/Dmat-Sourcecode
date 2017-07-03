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
import com.devopps.portal.model.AccountResponseBody;
import com.devopps.portal.model.AccountServiceResponse;
import com.devopps.portal.model.ApplicationDetails;
import com.devopps.portal.model.ApplicationEntity;
import com.devopps.portal.model.ApplicationRequestBody;
import com.devopps.portal.model.ApplicationResponseBody;
import com.devopps.portal.model.ApplicationServiceResponse;
import com.devopps.portal.model.BusinessUnitDetails;
import com.devopps.portal.model.BusinessUnitRequestBody;
import com.devopps.portal.model.BusinessUnitResponseBody;
import com.devopps.portal.model.BusinessUnitServiceResponse;
import com.devopps.portal.model.ManageAuditMappingRequestBody;
import com.devopps.portal.model.ManageAuditMappingResponseBody;
import com.devopps.portal.model.ManageAuditMappingServiceResponse;
import com.devopps.portal.model.AuditMappingDetails;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.model.SaveApplicationResponseBody;
import com.devopps.portal.model.SaveApplicationResponseHeader;
import com.devopps.portal.model.SaveApplicationServiceResponse;
import com.devopps.portal.model.UserEntity;
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
	public ApplicationServiceResponse getApplicationDetails(ApplicationRequestBody applicationRequestBody) {
		
		ApplicationServiceResponse response = new ApplicationServiceResponse();
		List<ApplicationDetails>  appDetails = null;
		try {
			appDetails = displayDao.getApplicationDetails(applicationRequestBody);
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
	
	@Override
	public List<ApplicationEntity> getApplications(String userId) {
		
		ApplicationEntity response = new ApplicationEntity();
		List<ApplicationDetails>  appDetails = null;
		try {
			appDetails = displayDao.getApplications(userId);
		} catch (HibernateException ex) {
		 	ExceptionHandler.handle(ex);
			return getApplicationsReponse(appDetails, IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return getApplicationsReponse(appDetails, IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE);
		}
		response = getApplications(appDetails, IStatusCodeConstants.STATUS_SUCCESS, IConstants.SUCCESS);
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


	@Override
	public BusinessUnitServiceResponse manageBusinessUnits(BusinessUnitRequestBody businessUnitRequestBody) {
		BusinessUnitServiceResponse response = new BusinessUnitServiceResponse();
		List<BusinessUnitDetails> businessUnitDetails = null;
		int businessUnitId = -1;
		try {
			if (businessUnitRequestBody.isViewOnly()) {
				businessUnitDetails = applicationDao.getBusinessUnits(businessUnitRequestBody);
			} else {
				businessUnitId = applicationDao.saveBusinessUnit(businessUnitRequestBody);
			}
		 } catch (HibernateException ex) {
			ExceptionHandler.handle(ex);
			return saveBusinessUnitReponse(businessUnitDetails, businessUnitId , IStatusCodeConstants.STATUS_FAILURE,IConstants.FAILURE);
		} catch (NoRecordsFoundException nx) {
			ExceptionHandler.handle(nx);
			return saveBusinessUnitReponse(businessUnitDetails , businessUnitId , IStatusCodeConstants.NO_RECORDS_FOUND,IConstants.NO_RECORDS_FOUND);
		} catch (DuplicateAreasException dx) {
			ExceptionHandler.handle(dx);
			return saveBusinessUnitReponse(businessUnitDetails ,businessUnitId ,  IStatusCodeConstants.STATUS_DUPLICATE,IConstants.DUPLICATE_AREA);
		}catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return saveBusinessUnitReponse(businessUnitDetails, businessUnitId , IStatusCodeConstants.STATUS_FAILURE,IConstants.FAILURE);
		}
		response = saveBusinessUnitReponse(businessUnitDetails , businessUnitId , IStatusCodeConstants.STATUS_SUCCESS,IConstants.SUCCESS);
		return response;
	}


	private BusinessUnitServiceResponse saveBusinessUnitReponse(
			List<BusinessUnitDetails> businessUnitDetails, int businessUnitId,
			String statusCode, String statusDesc) {
		BusinessUnitServiceResponse response = new BusinessUnitServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		BusinessUnitResponseBody responseBody = new BusinessUnitResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.HANDLE_BUSINESS_UNITS);
		responseBody.setBusinessUnitDetails(businessUnitDetails);
		responseBody.setBusinessUnitId(businessUnitId);
		response.setBusinessUnitResponseHeader(responseHeader);
		response.setBusinessUnitResponseBody(responseBody);
		return response;
		
	}


	@Override
	public ManageAuditMappingServiceResponse manageMasterData(
			ManageAuditMappingRequestBody masterDataMappingRequestBody) {
		
		ManageAuditMappingServiceResponse response = new ManageAuditMappingServiceResponse();
		List<AuditMappingDetails> auditMappingDetails = null;
		try {
			if (masterDataMappingRequestBody.isViewOnly()) {
				auditMappingDetails = applicationDao.getAuditMappingData(masterDataMappingRequestBody);
			} else {
				applicationDao.saveAuditMappingData(masterDataMappingRequestBody);
			}
		 } catch (HibernateException ex) {
			ExceptionHandler.handle(ex);
			return masterDataMappingReponse(auditMappingDetails,  IStatusCodeConstants.STATUS_FAILURE,IConstants.FAILURE);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return masterDataMappingReponse(auditMappingDetails, IStatusCodeConstants.STATUS_FAILURE,IConstants.FAILURE);
		}
		response = masterDataMappingReponse(auditMappingDetails ,IStatusCodeConstants.STATUS_SUCCESS,IConstants.SUCCESS);
		return response;
	}


	private ManageAuditMappingServiceResponse masterDataMappingReponse(
			List<AuditMappingDetails> auditMappingDetails, String statusCode, String statusDesc) {
		ManageAuditMappingServiceResponse manageAuditMappingServiceResponse = new ManageAuditMappingServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		ManageAuditMappingResponseBody responseBody = new ManageAuditMappingResponseBody();
		responseBody.setAuditMappingDetails(auditMappingDetails);
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.MANAGE_AUDIT_MAPPING);
		manageAuditMappingServiceResponse.setResponseHeader(responseHeader);
		manageAuditMappingServiceResponse.setManageAuditMappingResponseBody(responseBody);
		return manageAuditMappingServiceResponse;
	}
	
	
}
