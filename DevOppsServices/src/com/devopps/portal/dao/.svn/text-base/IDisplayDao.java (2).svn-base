package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AccountDetails;
import com.devopps.portal.model.AddAccountsRequestBody;
import com.devopps.portal.model.AddRolesRequestBody;
import com.devopps.portal.model.ApplicationDetails;
import com.devopps.portal.model.ApplicationRequestBody;
import com.devopps.portal.model.RoleDetails;
import com.devopps.portal.model.UserProfileDetails;

public interface IDisplayDao {
	
	public List<RoleDetails> getRoleDetails ();
	public List<AccountDetails> getAccountDetails ();
	public List<ApplicationDetails> getApplicationDetails (ApplicationRequestBody applicationRequestBody);
	public List<UserProfileDetails> getUserProfileDetails ();
	public int saveAccountDetails(AddAccountsRequestBody accountRequestBody) throws DuplicateAreasException,NoRecordsFoundException;
	int saveRoleDetails(AddRolesRequestBody accountRequestBody)
			throws  NoRecordsFoundException;
	
}
