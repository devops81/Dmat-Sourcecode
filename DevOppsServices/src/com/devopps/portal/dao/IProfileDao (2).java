package com.devopps.portal.dao;

import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.SaveNotificationRequestBody;
import com.devopps.portal.model.UserProfileRequestBody;

public interface IProfileDao {
	
	void saveUserProfile(UserProfileRequestBody userProfileRequestBody);
	void saveNotifications (SaveNotificationRequestBody saveNotificationRequestBody) throws NoRecordsFoundException;
	void saveProfile(String s) throws NoRecordsFoundException;;
	
	
}