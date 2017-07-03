package com.devopps.portal.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.devopps.portal.model.ISaveApplicationServiceParameters;
import com.devopps.portal.model.SaveApplicationServiceParameters;
import com.devopps.portal.model.SaveApplicationServiceRequest;

@Component("ApplicationServiceRequestResponseMapper")
public class ApplicationRequestResponseMapper implements IRequestResponseMapper {

	@Override
	public Object mapToInput(Map<String, Object> inputs) {
		SaveApplicationServiceRequest request=(SaveApplicationServiceRequest) inputs.get(SaveApplicationServiceRequest.class.getName());
		ISaveApplicationServiceParameters applicationServiceParameters=new SaveApplicationServiceParameters();
		applicationServiceParameters.setSaveApplicationRequest(request);
		return applicationServiceParameters;
	}

}
