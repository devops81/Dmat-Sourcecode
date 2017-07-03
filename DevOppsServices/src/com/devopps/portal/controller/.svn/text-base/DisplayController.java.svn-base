package com.devopps.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopps.portal.model.AccountServiceResponse;
import com.devopps.portal.model.AddAccountsRequestBody;
import com.devopps.portal.model.AddRolesRequestBody;
import com.devopps.portal.model.ApplicationRequestBody;
import com.devopps.portal.model.ApplicationServiceResponse;
import com.devopps.portal.model.RoleServiceResponse;
import com.devopps.portal.model.UserProfileServiceResponse;
import com.devopps.portal.service.IAccountService;
import com.devopps.portal.service.IApplicationService;
import com.devopps.portal.service.IRoleService;
import com.devopps.portal.service.IUserProfileService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/displayOptions")
public class DisplayController  extends AbstractController{

	@Autowired
	@Qualifier("IRoleService")
	IRoleService roleService;
	
	@Autowired
	@Qualifier("IAccountService")
	IAccountService accountService;
	
	@Autowired
	@Qualifier("IApplicationService")
	IApplicationService applicationService;
	
	@Autowired
	@Qualifier("IUserProfileService")
	IUserProfileService userProfileService;
	
	
	private static final Log LOGGER = LogFactory.getLog(DisplayController.class);
	
	/**
	 * URL : 
	 * http://localhost:8080/DevOppsServices/displayOptions/handleRoles/1.0
	 * @return
	 * 
	 * <role>
		  <isViewOnly>false</isViewOnly>
		  <saveOrUpdate>1</saveOrUpdate> // 1 is for save , else update
		  <roleId>4</roleId>
		  <roleName>Test Role</roleName>
		  <isActive>true</isActive>
		</role>
		
		Response - View 
		
		{"response": {
    "details": {
        "roleDetails": [
            {
                "active": true,
                "roleId": 1,
                "roleName": "Assessor"
            }
        ],
        "roleId": -1,
        "statusMsg": "Operation is a Success"
    },
    "header": {
        "operationName": "View/Add/Update Roles",
        "statusCode": 1,
        "statusDesc": "Operation is a Success"
    }
}}

	Response - Save or Update

	{"response": {
	    "details": {
	        "roleId": 2,
	        "statusMsg": "Operation is a Success"
	    },
	    "header": {
	        "operationName": "View/Add/Update Roles",
	        "statusCode": 1,
	        "statusDesc": "Operation is a Success"
	    }
	}}
	 */

	@RequestMapping(value = "/handleRoles/{version}", method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String handleRoles(HttpServletRequest request,@PathVariable Integer version, @RequestBody(required=true) AddRolesRequestBody rolesRequestBody) {
		LOGGER.debug("[fetchRoles] Service :: Start");
		RoleServiceResponse response = null;
		response =roleService.handleRoles(rolesRequestBody);
		LOGGER.debug("[fetchRoles()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		return convertXMlToJson (stringXML);
	}
	
	/**
	 * URL : 
	 * http://localhost:8080/DevOppsServices/displayOptions/handleAccounts/1.0
	 * 
	 * <account>
		  <isViewOnly>false</isViewOnly>
		  <saveOrUpdate>1</saveOrUpdate>
		  <accountId>4</accountId>
		  <accountName>Test Account</accountName>
	  <isActive>true</isActive>
	  </account>
	 *
	 *
	 *Response
	 */
	@RequestMapping(value = "/handleAccounts/{version}", method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String handleAccounts(HttpServletRequest request,@PathVariable Integer version, @RequestBody(required=true) AddAccountsRequestBody accountRequestBody) {
		LOGGER.debug("[fetchAccounts] Service :: Start");
		AccountServiceResponse response = null;
		response = accountService.handleAccounts(accountRequestBody);
		LOGGER.debug("[fetchAccounts()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		return convertXMlToJson (stringXML);
	}
	
	/**
	 * URL :
	 * http://localhost:8080/DevOppsServices/displayOptions/applications/1.0
	 * @param request
	 * @param version
	 * @return
	 */
	
	@RequestMapping(value = "/applications/{version}", method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String fetchApplications(HttpServletRequest request,@PathVariable Integer version,@RequestBody(required=true) ApplicationRequestBody applicationRequestBody) {
		LOGGER.debug("[fetchApplications] Service :: Start");
		ApplicationServiceResponse response = null;
		response = applicationService.getApplicationDetails(applicationRequestBody);
		LOGGER.debug("[fetchApplications()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		return convertXMlToJson (stringXML);
	}
	
	/**
	 * URL:
	 * http://localhost:8080/DevOppsServices/displayOptions/userProfiles/1.0
	 * @param request
	 * @param version
	 * @return
	 */
	@RequestMapping(value = "/userProfiles/{version}", method = RequestMethod.POST,produces = "application/xml")
	public @ResponseBody String fetchUserProfiles(HttpServletRequest request,@PathVariable Integer version) {
		LOGGER.debug("[fetchUserProfiles] Service :: Start");
		UserProfileServiceResponse response = null;
		response = userProfileService.getUserProfileDetails();
		LOGGER.debug("[fetchUserProfiles()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		return convertXMlToJson (stringXML);
	}
	
}

	
	
	
