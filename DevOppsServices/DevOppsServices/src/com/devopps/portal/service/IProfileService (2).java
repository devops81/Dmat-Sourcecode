package com.devopps.portal.service;

import com.devopps.portal.model.SaveNotificationRequestBody;
import com.devopps.portal.model.SaveNotificationServiceResponse;
import com.devopps.portal.model.SaveProfileServiceResponse;
import com.devopps.portal.model.UserProfileRequestBody;

public interface IProfileService {

	public SaveProfileServiceResponse saveUserProfile (UserProfileRequestBody userProfileRequestBody);
	public SaveNotificationServiceResponse saveNotifications (SaveNotificationRequestBody saveNotificationRequestBody);
	
}
