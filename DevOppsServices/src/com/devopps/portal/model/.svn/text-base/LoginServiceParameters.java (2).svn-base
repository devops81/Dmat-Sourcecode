package com.devopps.portal.model;

import java.util.HashMap;

@SuppressWarnings({"unchecked", "serial"})
public class LoginServiceParameters extends HashMap implements ILoginServiceParameters{

	public static final String KEY_GET_REQUEST = "_GET_REQUEST_KEY";
	public LoginServiceParameters(){
		super();
	}
	
	public LoginServiceRequest getLoginServiceRequest() {
		return (LoginServiceRequest) this.get(KEY_GET_REQUEST);
	}

	@SuppressWarnings("unchecked")
	public void setLoginServiceRequest(LoginServiceRequest request) {
		this.put(KEY_GET_REQUEST, request);
	}
}
