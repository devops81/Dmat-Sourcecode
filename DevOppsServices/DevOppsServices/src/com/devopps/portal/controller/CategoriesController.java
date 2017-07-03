package com.devopps.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopps.portal.model.CategoryServiceResponse;
import com.devopps.portal.model.SaveCategoriesRequestBody;
import com.devopps.portal.service.ICategoryService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/categories")
public class CategoriesController extends AbstractController{
	
	@Autowired
	@Qualifier("ICategoryService")
	ICategoryService categoryService;
	private static final Log LOGGER = LogFactory.getLog(CategoriesController.class);
	
	/**
	 * URL : http://localhost:8080/DevOppsServices/categories/getCategories/1.0/0
	 * 
	 * Response
	 * {"response": {
    "detail": {
        "categoryDetails": [
            {
                "active": true,
                "assessmentAreaName": "Test Area9",
                "assessmentId": 1,
                "categoryId": 29,
                "categoryName": "cat4",
                "weightage": 12
            }
        ],
        "categoryId": 0,
        "statusMsg": "Success"
    },
    "header": {
        "operationName": "Get Categories",
        "statusCode": 1,
        "statusDesc": "Success"
    	}
	}}
	 */
	@RequestMapping(value = "/getCategories/{version}/{assessmentId}", method = RequestMethod.POST,  produces = "application/xml")
	public @ResponseBody String getCategories(HttpServletRequest request,@PathVariable int assessmentId) {
		LOGGER.debug("[getCategories] Service :: Start");
		CategoryServiceResponse response = null;
		response =categoryService.getCategories(assessmentId);
		LOGGER.debug("[getCategories()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		return convertXMlToJson(stringXML);
	}
	/*
	 * URL : http://localhost:8080/DevOppsServices/categories/saveUpdateCategories/1.0
	 * <saveupdateRequest>
		<categoryId>-1</categoryId>
		<categoryName>test Category 5</categoryName>
		<assessmentId>2</assessmentId>
		<weightage>20</weightage>
		<isActive>true</isActive>
		</saveupdateRequest>

	 * 
	 */
	
	@RequestMapping(value = "saveUpdateCategories/{version}", method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String saveUpdateCategory(HttpServletRequest request,@PathVariable Integer version,@RequestBody(required=true) SaveCategoriesRequestBody saveCategoryRequestBody) {
		LOGGER.debug("[saveCategory] Service :: Start");
		CategoryServiceResponse categoryServiceResponse = null;
		categoryServiceResponse = categoryService.saveCategory(saveCategoryRequestBody);
		LOGGER.debug("[saveCategory()] :: Ends :: Response -> "+categoryServiceResponse);
		String stringXML = marshal(categoryServiceResponse);
		return convertXMlToJson(stringXML);
	}
}
