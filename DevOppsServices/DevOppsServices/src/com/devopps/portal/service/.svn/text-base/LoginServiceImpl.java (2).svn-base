package com.devopps.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.IUserDetailsDao;
import com.devopps.portal.model.ILoginServiceParameters;
import com.devopps.portal.model.LoginStatusServiceResponse;
import com.devopps.portal.model.LoginStatusServiceResponseBody;
import com.devopps.portal.model.LoginStatusServiceResponseHeader;
import com.devopps.portal.model.UserDetails;
import com.devopps.portal.model.UserEntity;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("ILoginService")
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	@Qualifier("IUserDetailsDao")
	IUserDetailsDao userDetailsDao;
	
	public LoginStatusServiceResponse validateLoginDetails(ILoginServiceParameters loginParams) {
		
		System.out.println("[register()] :: [Begins]");
		LoginStatusServiceResponse response = new LoginStatusServiceResponse();
			//Validate the user credentials 
			response = buildLoginResponse(loginParams);
			/*if(result.hasErrors()){
				System.out.println("[register()] [ENDS] with ERROR while Fetching Eligible Participants");
				return result;
			}*/
			return response;
	}
	
	private LoginStatusServiceResponse buildLoginResponse(ILoginServiceParameters loginParams)
	{
		LoginStatusServiceResponse response = new LoginStatusServiceResponse();
		UserDetails userInfo = new UserDetails();
		List<UserEntity> userData = userDetailsDao.listUser();
		userInfo.setLoginSuccessful(true);
		userInfo.setBusinessUnit(userData.get(0).getBusinessUnit());
		userInfo.setDesignation("AVP");
		userInfo.setUserName(userData.get(0).getName());
		LoginStatusServiceResponseHeader header = new LoginStatusServiceResponseHeader();
		header.setStatusCode(IStatusCodeConstants.STATUS_SUCCESS);
		header.setOperationName("O1");
		header.setStatusDesc("Success");
		LoginStatusServiceResponseBody body = new LoginStatusServiceResponseBody();
		body.setUserInfo(userInfo);
		response.setLoginResponseHeader(header);
		response.setLoginResponseBody(body);
		return response; 
	}
	/*private ILoginServiceResult getLoginEligibleParticipants(ILoginServiceParameters loginParams){
		System.out.println("[getRegistrationEligibleParticipants()] [Begins]");
		ILoginServiceResult serviceResult=new LoginServiceResultMap();
		serviceResult.setResult(null);
		System.out.println("[getRegistrationEligibleParticipants()] :: Ends");
		return serviceResult;
	}*/
	

}
