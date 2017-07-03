package com.devopps.portal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopps.portal.mapper.IRequestResponseMapper;
import com.devopps.portal.model.ILoginServiceParameters;
import com.devopps.portal.model.LoginServiceRequest;
import com.devopps.portal.model.LoginStatusServiceResponse;
import com.devopps.portal.service.ILoginService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;


@RestController
@RequestMapping("/login")
public class LoginController extends AbstractController{
	
	@Autowired
	@Qualifier("ILoginService")
	ILoginService loginService;
	
	@Autowired
	@Qualifier("LoginServiceRequestResponseMapper")
	private IRequestResponseMapper mapper;
	
	private static final Log LOGGER = LogFactory.getLog(LoginController.class);
	
	/**
	 * This service verifies the user details

	 * @param request
	 * @param operationName
	 * @param version
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/verifyUserDetails/{userId}/{password}", method = RequestMethod.POST, consumes = "application/xml", produces = "application/xml")
	public @ResponseBody String verifyUserDetails(HttpServletRequest request,@PathVariable String userId,@PathVariable String password) {
		LOGGER.debug("Within userVerification service");
		LoginStatusServiceResponse response = null;
		ILoginServiceParameters parameters=(ILoginServiceParameters) mapper.mapToInput(buildInputMap(userId,password));
		response =loginService.validateLoginDetails(parameters);
		LOGGER.debug("[registerMember()] :: Ends :: Response -> ");
		String stringXML = marshal(response);
		return stringXML;
	}
	
	
	private Map<String,Object> buildInputMap(String userId,String password){
			LOGGER.debug("[buildInputMap()] :: Begins");
			LoginServiceRequest requestParam=new LoginServiceRequest();
			requestParam.setUserId(userId);
			requestParam.setPassword(password);
			Map<String,Object> mapperInputs=new HashMap<String, Object>();
			mapperInputs.put(LoginServiceRequest.class.getName(), requestParam);
			LOGGER.debug("[buildInputMap()] :: Ends");
			return mapperInputs;
		}
	
}
