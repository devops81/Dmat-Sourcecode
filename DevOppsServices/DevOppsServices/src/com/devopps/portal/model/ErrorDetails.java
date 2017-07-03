package com.devopps.portal.model;

public class ErrorDetails implements IErrorDetails {
	protected String errorCode;
	protected String errorMessage;
	 
	@Override
	public String getErrorCode() {
		return errorCode;
	}
	
	@Override
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
