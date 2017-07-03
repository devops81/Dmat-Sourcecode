package com.devopps.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.model.SaveApplicationServiceResponse;
import com.devopps.portal.service.IApplicationService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/applications")
public class SaveApplicationController extends AbstractController {
	
	@Autowired
	@Qualifier("IApplicationService")
	IApplicationService applicationService;
	
	private static final Log LOGGER = LogFactory.getLog(SaveApplicationController.class);
	
	/**
	 * URL :
	 * http://localhost:8080/DevOppsServices/applications/saveApplicationDetails/1.0
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
	
}
