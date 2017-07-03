package com.devopps.portal.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.devopps.portal.model.ILoginServiceParameters;
import com.devopps.portal.model.LoginServiceParameters;
import com.devopps.portal.model.LoginServiceRequest;

@Component("LoginServiceRequestResponseMapper")
public class LoginServiceRequestResponseMapper implements IRequestResponseMapper {
	
	@Override
	public Object mapToInput(Map<String, Object> inputs) {
		LoginServiceRequest request=(LoginServiceRequest) inputs.get(LoginServiceRequest.class.getName());
		ILoginServiceParameters loginServiceParameters=new LoginServiceParameters();
		loginServiceParameters.setLoginServiceRequest(request);
		return loginServiceParameters;
	}

/*	@Override
	public IServiceResponse mapToOutput(ILoginServiceResult result,String serviceName) {
		LoginStatusServiceResponseHeader header=new LoginStatusServiceResponseHeader();
		LoginStatusServiceResponseBody body=new LoginStatusServiceResponseBody();
		ILoginServiceResult serviceResult=(ILoginServiceResult) result;
		LoginServiceRequest request=(LoginServiceRequest) serviceResult.getRequest();
	}*/
}
