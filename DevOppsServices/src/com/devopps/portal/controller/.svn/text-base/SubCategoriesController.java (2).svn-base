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

import com.devopps.portal.model.SaveSubCategoriesRequest;
import com.devopps.portal.model.SubCategoryServiceResponse;
import com.devopps.portal.service.ISubCategoryService;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

@RestController
@RequestMapping("/subCategories")
public class SubCategoriesController extends AbstractController{
	
	@Autowired
	@Qualifier("ISubCategoryService")
	ISubCategoryService subCategoryService;
	private static final Log LOGGER = LogFactory.getLog(CategoriesController.class);
	
	/*
	 * URL : http://localhost:8080/DevOppsServices/subCategories/getSubCategories/1.0/0/1
	 */
	@RequestMapping(value = "getSubCategories/{version}/{categoryId}/{questionnaireType}", method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String fetchSubCategories(HttpServletRequest request,@PathVariable int categoryId,@PathVariable int questionnaireType) {
		LOGGER.debug("[fetchSubCategories] Service :: Start");
		String indentedJson = null;
		SubCategoryServiceResponse response = null;
		response =subCategoryService.getSubCategories(categoryId,questionnaireType);
		LOGGER.debug("[fetchSubCategories()] :: Ends :: Response -> "+response);
		String stringXML = marshal(response);
		indentedJson = convertXMlToJson (stringXML);
		return indentedJson;
	}
	
	/*
	 * URL : http://localhost:8080/DevOppsServices/subCategories/saveSubCategories/1.0
	 * <saveSubCategoriesRequest>
		<subCategoryId>-1</subCategoryId>
		<subCategoryName>Test SubCategory 1</subCategoryName>
		<categoryId>1</categoryId>
		<weightage>30</weightage>
		<isActive>true</isActive>
		<questionnaireType>1</questionnaireType>
		</saveSubCategoriesRequest>


	 */
	@RequestMapping(value = "saveSubCategories/{version}", method = RequestMethod.POST, produces = "application/xml")
	public @ResponseBody String saveSubCategory(HttpServletRequest request,@PathVariable Integer version,@RequestBody SaveSubCategoriesRequest saveSubCategoriesRequest ) {
		LOGGER.debug("[saveSubCategory] Service :: Start");
		String indentedJson = null;
		SubCategoryServiceResponse subCategoryServiceResponse = null;
		subCategoryServiceResponse = subCategoryService.saveSubCategory(saveSubCategoriesRequest);
		LOGGER.debug("[saveSubCategory()] :: Ends :: Response -> "+subCategoryServiceResponse);
		String stringXML = marshal(subCategoryServiceResponse);
		indentedJson = convertXMlToJson (stringXML);
		return indentedJson;
	}
	
}
