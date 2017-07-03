package com.devopps.portal.service;

import com.devopps.portal.model.SaveSubCategoriesRequest;
import com.devopps.portal.model.SubCategoryServiceResponse;

public interface ISubCategoryService {
	
	public SubCategoryServiceResponse getSubCategories (int categoryId,int questionnaireType);
	SubCategoryServiceResponse saveSubCategory(SaveSubCategoriesRequest saveSubCategoriesRequest);

}
