package com.devopps.portal.service;

import com.devopps.portal.model.CategoryServiceResponse;
import com.devopps.portal.model.SaveCategoriesRequestBody;

public interface ICategoryService {

	public CategoryServiceResponse getCategories (int assessmentId, int questionnaireType);

	public CategoryServiceResponse saveCategory(SaveCategoriesRequestBody saveCategoryRequestBody);
}
