package com.devopps.portal.model;

public interface ILoginServiceResult {
	
	public Object getResult(); 
	public void setResult(Object result);
	public Boolean hasErrors();
	public void setErrors(Boolean value);
}
