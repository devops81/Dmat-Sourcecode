package com.devopps.portal.model;

import java.util.HashMap;

@SuppressWarnings({"unchecked", "serial"})
public class SaveQuestionServiceParameters extends HashMap implements ISaveQuestionServiceParameters{

	public static final String KEY_GET_REQUEST = "_GET_REQUEST_KEY";
	
	public SaveQuestionServiceParameters(){
		super();
	}
	
	@Override
	public SaveQuestionServiceRequest getSaveQuestionRequest() {
		return (SaveQuestionServiceRequest) this.get(KEY_GET_REQUEST);
	}

	@Override
	public void setSaveQuestionRequest(SaveQuestionServiceRequest request) {
		this.put(KEY_GET_REQUEST, request);
		
	}

}
