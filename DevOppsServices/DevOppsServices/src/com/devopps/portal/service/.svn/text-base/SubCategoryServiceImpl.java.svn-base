package com.devopps.portal.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.devopps.portal.dao.ISubCategoryDao;
import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.ExceptionHandler;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.CategorySubCategoryDetails;
import com.devopps.portal.model.ResponseHeader;
import com.devopps.portal.model.SaveSubCategoriesRequest;
import com.devopps.portal.model.SubCategoryResponseBody;
import com.devopps.portal.model.SubCategoryServiceResponse;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IStatusCodeConstants;

@Component("ISubCategoryService")
public class SubCategoryServiceImpl implements ISubCategoryService {

	@Autowired
	@Qualifier("ISubCategoryDao")
	ISubCategoryDao subCategoryDao;
	
	@Override
	public SubCategoryServiceResponse getSubCategories(int categoryId) {
		SubCategoryServiceResponse response = new SubCategoryServiceResponse();
		List<CategorySubCategoryDetails>  subCategoryDetails = null;
		try {
			subCategoryDetails = subCategoryDao.getSubCategories(categoryId);
		} catch (HibernateException ex) {
		 	ex.printStackTrace();
			 return buildGetSubcategoriesResponse(subCategoryDetails, IConstants.FAILURE, IStatusCodeConstants.STATUS_FAILURE);
		} catch (Exception ex) {
			ex.printStackTrace();
			 return buildGetSubcategoriesResponse(subCategoryDetails, IConstants.FAILURE, IStatusCodeConstants.STATUS_FAILURE);
		}
		response = buildGetSubcategoriesResponse(subCategoryDetails,IConstants.SUCCESS, IStatusCodeConstants.STATUS_SUCCESS);
		return response;
	}
	
	@Override
	public SubCategoryServiceResponse saveSubCategory(SaveSubCategoriesRequest saveSubCategoriesRequest){
		SubCategoryServiceResponse subCategoryServiceResponse = new SubCategoryServiceResponse();
		int subCategoryId = -1;
		try {
			subCategoryId = subCategoryDao.saveSubCategory(saveSubCategoriesRequest);
		}  catch (HibernateException ex) {
		 	ex.printStackTrace();
			return buildSaveSubCategoryResponse(IConstants.FAILURE, IStatusCodeConstants.STATUS_FAILURE, subCategoryId);
		} catch (DuplicateAreasException dx) {
			ExceptionHandler.handle(dx);
			return buildSaveSubCategoryResponse(IConstants.DUPLICATE_AREA,IStatusCodeConstants.STATUS_DUPLICATE, subCategoryId);
		} catch (NoRecordsFoundException rfx) {
			ExceptionHandler.handle(rfx);
			return buildSaveSubCategoryResponse(IConstants.NO_RECORDS_FOUND, IStatusCodeConstants.NO_RECORDS_FOUND, subCategoryId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return buildSaveSubCategoryResponse(IConstants.FAILURE,IStatusCodeConstants.STATUS_FAILURE, subCategoryId);
		}
		subCategoryServiceResponse = buildSaveSubCategoryResponse(IConstants.SUCCESS,IStatusCodeConstants.STATUS_SUCCESS, subCategoryId);
		return subCategoryServiceResponse;
	}
	
	private SubCategoryServiceResponse buildGetSubcategoriesResponse(List<CategorySubCategoryDetails> subCategoryDetails, String statusDesc, String statusCode) {
		SubCategoryServiceResponse response = new SubCategoryServiceResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		SubCategoryResponseBody responseBody = new SubCategoryResponseBody();
		responseHeader.setStatusCode(statusCode);
		responseHeader.setStatusDesc(statusDesc);
		responseHeader.setOperationName(IConstants.FETCH_SUBCATEGORIES);
		responseBody.setStatusMsg(statusDesc);
		responseBody.setSubCategoryDetails(subCategoryDetails);
		response.setSubCategoryResponseHeader(responseHeader);
		response.setSubCategoryResponseBody(responseBody);
		return response;
	}
	
	
	
	private SubCategoryServiceResponse buildSaveSubCategoryResponse(String statusDesc, String statusCode, int subCategoryId) {
		
		SubCategoryServiceResponse subCategoryServiceResponse = new SubCategoryServiceResponse();
		ResponseHeader subCategoryResponseHeader = new ResponseHeader();
		SubCategoryResponseBody subCategoryResponseBody = new SubCategoryResponseBody();
		subCategoryResponseHeader.setStatusCode(statusCode);
		subCategoryResponseHeader.setStatusDesc(statusDesc);
		subCategoryResponseHeader.setOperationName(IConstants.SAVE_SUB_CATEGORY);
		subCategoryResponseBody.setStatusMsg(statusDesc);
		subCategoryResponseBody.setSubCategoryId(subCategoryId);
		subCategoryServiceResponse.setSubCategoryResponseHeader(subCategoryResponseHeader);
		subCategoryServiceResponse.setSubCategoryResponseBody(subCategoryResponseBody);
		return subCategoryServiceResponse;
	}

}
