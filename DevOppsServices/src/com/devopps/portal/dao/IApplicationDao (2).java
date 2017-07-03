package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.BusinessUnitDetails;
import com.devopps.portal.model.BusinessUnitRequestBody;
import com.devopps.portal.model.ISaveApplicationServiceParameters;
import com.devopps.portal.model.ManageAuditMappingRequestBody;
import com.devopps.portal.model.ApplicationEntity;
import com.devopps.portal.model.AuditMappingDetails;
import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.model.UserEntity;

public interface IApplicationDao {
	
	void saveApplicationDetails (ISaveApplicationServiceParameters saveApplicationServiceParams);
	int saveApplication (SaveApplicationRequestBody saveApplicationRequestBody) throws DuplicateAreasException, NoRecordsFoundException;
	int saveBusinessUnit(BusinessUnitRequestBody businessUnitRequestBody) throws NoRecordsFoundException, DuplicateAreasException;
	List<BusinessUnitDetails> getBusinessUnits(BusinessUnitRequestBody businessUnitRequestBody);
	List<AuditMappingDetails> getAuditMappingData(ManageAuditMappingRequestBody masterDataMappingRequestBody);
	void saveAuditMappingData(ManageAuditMappingRequestBody masterDataMappingRequestBody);
    List<ApplicationEntity> getApplications(String userId);
	
}
