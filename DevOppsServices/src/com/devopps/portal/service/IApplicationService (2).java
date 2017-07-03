package com.devopps.portal.service;

import com.devopps.portal.model.ApplicationRequestBody;
import com.devopps.portal.model.ApplicationServiceResponse;
import com.devopps.portal.model.BusinessUnitRequestBody;
import com.devopps.portal.model.BusinessUnitServiceResponse;
import com.devopps.portal.model.ManageAuditMappingRequestBody;
import com.devopps.portal.model.ManageAuditMappingServiceResponse;
import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.model.SaveApplicationServiceResponse;

public interface IApplicationService {
	
	public SaveApplicationServiceResponse saveApplication (SaveApplicationRequestBody saveApplicationRequestBody);
	public ApplicationServiceResponse getApplicationDetails(ApplicationRequestBody applicationRequestBody);
	public BusinessUnitServiceResponse manageBusinessUnits(BusinessUnitRequestBody businessUnitRequestBody);
	public ManageAuditMappingServiceResponse manageMasterData (ManageAuditMappingRequestBody masterDataMappingRequestBody);
	ApplicationServiceResponse getApplications(ApplicationRequestBody applicationRequestBody);

}