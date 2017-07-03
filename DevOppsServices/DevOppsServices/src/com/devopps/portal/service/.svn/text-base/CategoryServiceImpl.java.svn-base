package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.ICategoryDao;
import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AssessmentCategoryDetails;
import com.devopps.portal.model.CategoryResponseBody;
import com.devopps.portal.model.CategoryServiceResponse;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveCategoriesRequestBody;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("ICategoryService")
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	@Qualifier("ICategoriesDao")
	ICategoryDao categoriesDao;
	
	@Override
	public CategoryServiceResponse getCategories(int assessmentId) {
		CategoryServiceResponse response = new CategoryServiceResponse();
		List<AssessmentCategoryDetails>  categoryDetails = null;
		try {
			categoryDetails = categoriesDao.getCategories(assessmentId);
		} catch (HibernateException ex) {
		 	ExceptionHandler.handle(ex);
			return buildGetCategoryResponse(categoryDetails, IConstants.FAILURE , IStatusCodeConstants.STATUS_FAILURE);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return buildGetCategoryResponse(categoryDetails, IConstants.FAILURE, IStatusCodeConstants.STATUS_FAILURE);
		}
		response = buildGetCategoryResponse(categoryDetails, IConstants.SUCCESS,  IStatusCodeConstants.STATUS_SUCCESS);
		return response;
	}
	
	@Override
	public CategoryServiceResponse saveCategory(SaveCategoriesRequestBody saveCategoryRequestBody){
		CategoryServiceResponse categoryServiceResponse = new CategoryServiceResponse();
		int categoryId = -1;
		try {
			categoryId = categoriesDao.saveCategory(saveCategoryRequestBody);
		}  catch (HibernateException ex) {
			ExceptionHandler.handle(ex);
			return buildSaveCategoryResponse(IConstants.FAILURE, IStatusCodeConstants.STATUS_FAILURE, categoryId);
		} catch (DuplicateAreasException dx) {
			ExceptionHandler.handle(dx);
			return buildSaveCategoryResponse(IConstants.DUPLICATE_AREA, IStatusCodeConstants.STATUS_DUPLICATE, categoryId);
		} catch (NoRecordsFoundException rfx) {
			ExceptionHandler.handle(rfx);
			return buildSaveCategoryResponse(IConstants.NO_RECORDS_FOUND, IStatusCodeConstants.NO_RECORDS_FOUND, categoryId);
		} catch (Exception ex) {
			ExceptionHandler.handle(ex);
			return buildSaveCategoryResponse(IConstants.FAILURE, IStatusCodeConstants.STATUS_FAILURE, categoryId);
		}
		categoryServiceResponse = buildSaveCategoryResponse(IConstants.SUCCESS, IStatusCodeConstants.STATUS_SUCCESS, categoryId);
		return categoryServiceResponse;
	}
	
	private CategoryServiceResponse buildGetCategoryResponse (List<AssessmentCategoryDetails> categoryDetails, String statusDesc, String statusCode) {
		CategoryServiceResponse response = new CategoryServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		CategoryResponseBody responseBody = new CategoryResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.FETCH_CATEGORIES);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setCategoryDetails(categoryDetails);
		response.setCategoryResponseHeader(responseHeader);
		response.setCategoryResponseBody(responseBody);
		return response;
	}
	
private CategoryServiceResponse buildSaveCategoryResponse(String statusDesc, String statusCode , int categoryId) {
		
		CategoryServiceResponse response = new CategoryServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		CategoryResponseBody responseBody = new CategoryResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.SAVE_CATEGORY);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setCategoryId(categoryId);
		response.setCategoryResponseHeader(responseHeader);
		response.setCategoryResponseBody(responseBody);
		return response;
	}
	

	
	
}
