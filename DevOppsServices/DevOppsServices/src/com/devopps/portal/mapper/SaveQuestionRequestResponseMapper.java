package com.devopps.portal.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.devopps.portal.mapper.IRequestResponseMapper;
import com.devopps.portal.model.ISaveQuestionServiceParameters;
import com.devopps.portal.model.SaveQuestionServiceParameters;
import com.devopps.portal.model.SaveQuestionServiceRequest;

@Component("SaveQuestionRequestResponseMapper")
public class SaveQuestionRequestResponseMapper implements IRequestResponseMapper{

	@Override
	public Object mapToInput(Map<String, Object> inputs) {
		SaveQuestionServiceRequest request=(SaveQuestionServiceRequest) inputs.get(SaveQuestionServiceRequest.class.getName());
		ISaveQuestionServiceParameters questionServiceParameters = new SaveQuestionServiceParameters();
		questionServiceParameters.setSaveQuestionRequest(request);
		return questionServiceParameters;
	}
	
}
