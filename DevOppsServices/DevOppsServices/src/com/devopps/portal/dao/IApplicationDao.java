package com.devopps.portal.dao;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.ISaveApplicationServiceParameters;
import com.devopps.portal.model.SaveApplicationRequestBody;

public interface IApplicationDao {
	
	void saveApplicationDetails (ISaveApplicationServiceParameters saveApplicationServiceParams);
	int saveApplication (SaveApplicationRequestBody saveApplicationRequestBody) throws DuplicateAreasException, NoRecordsFoundException;
}
