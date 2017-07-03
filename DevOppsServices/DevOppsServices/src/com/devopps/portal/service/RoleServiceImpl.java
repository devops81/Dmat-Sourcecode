package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IDisplayDao;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AddRolesRequestBody;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.RoleDetails;
import com.devopps.portal.model.RoleResponseBody;
import com.devopps.portal.model.RoleServiceResponse;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IRoleService")
public class RoleServiceImpl implements IRoleService{

	@Autowired
	@Qualifier("IDisplayDao")
	IDisplayDao displayDao;
	
	@Override
	public RoleServiceResponse handleRoles(
			AddRolesRequestBody rolesRequestBody) {
		int roleId = -1;
		List<RoleDetails> roleDetails = null;
		try {
			 if (rolesRequestBody.isViewOnly()) {
				 roleDetails = displayDao.getRoleDetails();
			 } else {
				 roleId = displayDao.saveRoleDetails(rolesRequestBody);
			 }
		} catch (HibernateException ex) {
			 	ExceptionHandler.handle(ex);
				return buildRolesReponse(roleDetails, roleId, IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE_MESSAGE);
			} catch (NoRecordsFoundException nfe) {
				ExceptionHandler.handle(nfe);
				return buildRolesReponse(roleDetails, roleId,IStatusCodeConstants.NO_RECORDS_FOUND, IConstants.NO_RECORDS_FOUND);
			} catch (Exception ex) {
				ExceptionHandler.handle(ex);
				return buildRolesReponse(roleDetails, roleId,IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE_MESSAGE);
			}
			return buildRolesReponse (roleDetails, roleId,IStatusCodeConstants.STATUS_SUCCESS,IConstants.SUCCESS_MESSAGE);
	}

	private RoleServiceResponse buildRolesReponse(List<RoleDetails> roleDetails, int roleId, String statusCode, String statusDesc) {
		RoleServiceResponse response = new RoleServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		RoleResponseBody responseBody = new RoleResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.HANDLE_ROLES);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setRoleDetails(roleDetails);
		responseBody.setRoleId(roleId);
		response.setResponseHeader(responseHeader);
		response.setRoleResponseBody(responseBody);
		return response;
	}
	
}




