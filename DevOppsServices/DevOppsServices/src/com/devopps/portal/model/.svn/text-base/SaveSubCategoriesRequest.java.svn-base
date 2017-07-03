package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subCategoryId",
    "subCategoryName",
    "categoryId",
    "weightage",
    "isActive"
})
@XmlRootElement(name = "saveSubCategoriesRequest")
public class SaveSubCategoriesRequest {
	
	@XmlElement(required = true)
	private int subCategoryId;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(AdapterXmlCDATA.class)
	private String subCategoryName;
	
	@XmlElement(required = true)
	private int categoryId;
	
	@XmlElement(required = true)
	private int weightage;
	
	@XmlElement(required = true)
	private boolean isActive;
	
	/**
	 * @return the subCategoryId
	 */
	public int getSubCategoryId() {
		return subCategoryId;
	}
	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}
	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the weightage
	 */
	public int getWeightage() {
		return weightage;
	}
	/**
	 * @param weightage the weightage to set
	 */
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
