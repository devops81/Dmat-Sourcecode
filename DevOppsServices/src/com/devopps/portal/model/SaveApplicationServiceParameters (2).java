package com.devopps.portal.model;

import java.util.HashMap;

@SuppressWarnings({"unchecked", "serial"})
public class SaveApplicationServiceParameters extends HashMap implements ISaveApplicationServiceParameters{

	public static final String KEY_GET_REQUEST = "_GET_REQUEST_KEY";
	public SaveApplicationServiceParameters(){
		super();
	}
	
	@Override
	public SaveApplicationServiceRequest getSaveApplicationRequest() {
		return (SaveApplicationServiceRequest) this.get(KEY_GET_REQUEST);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setSaveApplicationRequest(SaveApplicationServiceRequest request) {
		this.put(KEY_GET_REQUEST, request);
	}
	

}
