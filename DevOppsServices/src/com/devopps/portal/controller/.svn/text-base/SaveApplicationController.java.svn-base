package com.devopps.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopps.portal.model.BusinessUnitRequestBody;
import com.devopps.portal.model.BusinessUnitServiceResponse;
import com.devopps.portal.model.ManageAuditMappingRequestBody;
import com.devopps.portal.model.ManageAuditMappingServiceResponse;
import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.model.SaveApplicationServiceResponse;
import com.devopps.portal.service.IApplicationService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/system")
public class SaveApplicationController extends AbstractController {
	
	@Autowired
	@Qualifier("IApplicationService")
	IApplicationService applicationService;
	
	private static final Log LOGGER = LogFactory.getLog(SaveApplicationController.class);
	
	/**
	 * URL :
	 * http://localhost:8080/DevOppsServices/system/saveApplicationDetails/1.0
	 * 
	 * <saveApplication>
	 *  <applicationId>-1</applicationId>
	 *  <applicationName> Connecticut </applicationName>
	 *  <isActive>true</isActive>
	 * </saveApplication>
	 * 
	 * @param request
	 * @param saveApplicationRequestBody
	 * @return
	 */
	@RequestMapping(value = "/saveApplicationDetails/{version}", method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String saveUserApplications(HttpServletRequest request,@RequestBody (required = true) SaveApplicationRequestBody saveApplicationRequestBody) {
		LOGGER.debug("[saveUserApplications] Service :: Start");
		SaveApplicationServiceResponse response = null;
		response =applicationService.saveApplication(saveApplicationRequestBody);
		LOGGER.debug("[saveUserApplications()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		 return convertXMlToJson(stringXML);
	}
	
	
	/**
	 * URL :
	 * http://localhost:8080/DevOppsServices/system/manageBusinessUnitDetails/1.0
	 * 
	 * <manageBusinessUnit>
	 *  <isViewOnly>true</isViewOnly>
	 *  <businessUnitId>-1</businessUnitId>
	 *  <businessUnitName> Connecticut </businessUnitName>
	 *  <accountId></accountId>
	 *  <isActive>true</isActive>
	 * </manageBusinessUnit>
	 * 
	 * @param request
	 * @param saveApplicationRequestBody
	 * @return
	 */
	@RequestMapping(value = "/manageBusinessUnits/{version}", method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String manageBusinessUnits(HttpServletRequest request,@RequestBody (required = true) BusinessUnitRequestBody businessUnitRequestBody) {
		LOGGER.debug("[manageBusinessUnits] Service :: Start");
		BusinessUnitServiceResponse response = null;
		response =applicationService.manageBusinessUnits(businessUnitRequestBody);
		LOGGER.debug("[manageBusinessUnits()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		 return convertXMlToJson(stringXML);
	}
	
	@RequestMapping(value = "/manageAuditReports/{version}", method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String manageAuditReports(HttpServletRequest request,@RequestBody (required = true) ManageAuditMappingRequestBody manageAuditMappingRequestBody) {
		LOGGER.debug("[manageMasterData] Service :: Start");
		ManageAuditMappingServiceResponse response = null;
		response =applicationService.manageMasterData(manageAuditMappingRequestBody);
		LOGGER.debug("[manageMasterData()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		 return convertXMlToJson(stringXML);
	}
	
}
