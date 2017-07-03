package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.CategorySubCategoryDetails;
import com.devopps.portal.model.SaveSubCategoriesRequest;

public interface ISubCategoryDao {
	
	public List<CategorySubCategoryDetails> getSubCategories (int categoryId);

	int saveSubCategory(SaveSubCategoriesRequest saveSubCategoriesRequest) throws DuplicateAreasException, NoRecordsFoundException;
}
