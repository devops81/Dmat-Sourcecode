package com.devopps.portal.service;

import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IDisplayDao;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.UserProfileDetails;
import com.devopps.portal.model.UserProfileResponseBody;
import com.devopps.portal.model.UserProfileServiceResponse;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IUserProfileService")
public class UserProfileServiceImpl implements IUserProfileService {

	@Autowired
	@Qualifier("IDisplayDao")
	IDisplayDao displayDao;

	@Override
	public UserProfileServiceResponse getUserProfileDetails() {

		UserProfileServiceResponse response = new UserProfileServiceResponse();
		List<UserProfileDetails>  userProfileDetails = null;
		try {
			userProfileDetails = displayDao.getUserProfileDetails();
		} catch (HibernateException ex) {
		 	ExceptionHandler.handle(ex);
			return buildUserProfileResponse(userProfileDetails , IStatusCodeConstants.STATUS_FAILURE , IConstants.FAILURE);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return buildUserProfileResponse(userProfileDetails, IStatusCodeConstants.STATUS_FAILURE , IConstants.FAILURE);
		}
		response = buildUserProfileResponse(userProfileDetails, IStatusCodeConstants.STATUS_SUCCESS , IConstants.SUCCESS);
		System.out.println("time"+Calendar.getInstance().getTimeInMillis());
		return response;
		
		
	}
	
	private UserProfileServiceResponse buildUserProfileResponse(List<UserProfileDetails> roleDetails , String statusCode, String statusDesc) {
		UserProfileServiceResponse response = new UserProfileServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		UserProfileResponseBody responseBody = new UserProfileResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.DISPLAY_PROFILE);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setUserProfileDetails(roleDetails);
		response.setResponseHeader(responseHeader);
		response.setUserProfileResponseBody(responseBody);
		return response;
	}
}

