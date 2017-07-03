package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IDisplayDao;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AccountDetails;
import com.devopps.portal.model.AccountResponseBody;
import com.devopps.portal.model.AccountServiceResponse;
import com.devopps.portal.model.AddAccountsRequestBody;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("IAccountService")
public class AccountServiceImpl implements IAccountService{

	@Autowired
	@Qualifier("IDisplayDao")
	IDisplayDao displayDao;

	@Override
	public AccountServiceResponse handleAccounts(
			AddAccountsRequestBody accountRequestBody) {
		int accountId = -1;
		List<AccountDetails> accountDetails = null;
		try {
			 if (accountRequestBody.isViewOnly()) {
				 accountDetails = displayDao.getAccountDetails();
			 } else {
				 accountId = displayDao.saveAccountDetails(accountRequestBody);
			 }
		} catch (HibernateException ex) {
			 	ExceptionHandler.handle(ex);
				return buildAccountsReponse(accountDetails, accountId, IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE_MESSAGE);
			} catch (NoRecordsFoundException nfe) {
				ExceptionHandler.handle(nfe);
				return buildAccountsReponse(accountDetails, accountId,IStatusCodeConstants.NO_RECORDS_FOUND, IConstants.NO_RECORDS_FOUND);
			} catch (Exception ex) {
				ExceptionHandler.handle(ex);
				return buildAccountsReponse(accountDetails, accountId,IStatusCodeConstants.STATUS_FAILURE, IConstants.FAILURE_MESSAGE);
			}
			return buildAccountsReponse (accountDetails, accountId,IStatusCodeConstants.STATUS_SUCCESS,IConstants.SUCCESS_MESSAGE);
	}

	private AccountServiceResponse buildAccountsReponse(List<AccountDetails> accountDetails, int accountId, String statusCode, String statusDesc) {
		AccountServiceResponse response = new AccountServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		AccountResponseBody responseBody = new AccountResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.HANDLE_ACCOUNTS);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setAccountDetails(accountDetails);
		responseBody.setAccountId(accountId);
		response.setResponseHeader(responseHeader);
		response.setAccountResponseBody(responseBody);
		return response;
	}

}
