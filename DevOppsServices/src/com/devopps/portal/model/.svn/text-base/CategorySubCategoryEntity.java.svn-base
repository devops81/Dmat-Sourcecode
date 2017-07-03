package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_subcategory_mapping")
public class CategorySubCategoryEntity {
	
	private int subCategoryId;
	private int categoryId;
	
	/**
	 * @return the subCategoryId
	 */
	@Id
	@Column(name="subcategory_id")
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
	 * @return the categoryId
	 */
	@Column(name="category_id")
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}