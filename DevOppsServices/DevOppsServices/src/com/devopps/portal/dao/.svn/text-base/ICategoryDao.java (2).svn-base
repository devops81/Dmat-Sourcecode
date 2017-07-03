package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AssessmentCategoryDetails;
import com.devopps.portal.model.SaveCategoriesRequestBody;

public interface ICategoryDao {
	
	List<AssessmentCategoryDetails> getCategories(int assessmentId);
	int saveCategory(SaveCategoriesRequestBody saveCategoryRequestBody) throws DuplicateAreasException, NoRecordsFoundException;
}
