package com.devopps.portal.service;

import java.util.List;

import com.devopps.portal.model.ApplicationEntity;
import com.devopps.portal.model.SaveNotificationRequestBody;
import com.devopps.portal.model.SaveNotificationServiceResponse;
import com.devopps.portal.model.SaveProfileServiceResponse;
import com.devopps.portal.model.UserProfileRequestBody;

public interface IProfileService {

	public SaveProfileServiceResponse saveUserProfile (UserProfileRequestBody userProfileRequestBody);
	public SaveNotificationServiceResponse saveNotifications (SaveNotificationRequestBody saveNotificationRequestBody);
	
	public String saveProfile(UserProfileRequestBody userProfileRequestBody);
	public String saveProfile(String s);
	public List<ApplicationEntity> getApplications(String userId);
	
}
