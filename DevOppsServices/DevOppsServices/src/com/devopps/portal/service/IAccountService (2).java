package com.devopps.portal.service;

import com.devopps.portal.model.AccountServiceResponse;
import com.devopps.portal.model.AddAccountsRequestBody;

public interface IAccountService {
	
	public AccountServiceResponse handleAccounts(AddAccountsRequestBody addAccountsRequestBody);
}
