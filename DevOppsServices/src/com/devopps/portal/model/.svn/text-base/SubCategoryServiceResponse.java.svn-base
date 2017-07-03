package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"subCategoryResponseHeader", "subCategoryResponseBody"})
public class SubCategoryServiceResponse {
	
	private ResponseHeader subCategoryResponseHeader;
	private SubCategoryResponseBody subCategoryResponseBody;

	/**
	 * @return the subCategoryResponseHeader
	 */
	@XmlElement(name="header")
	public ResponseHeader getSubCategoryResponseHeader() {
		return subCategoryResponseHeader;
	}

	/**
	 * @param subCategoryResponseHeader the subCategoryResponseHeader to set
	 */
	public void setSubCategoryResponseHeader(
			ResponseHeader subCategoryResponseHeader) {
		this.subCategoryResponseHeader = subCategoryResponseHeader;
	}

	/**
	 * @return the subCategoryResponseBody
	 */
	@XmlElement(name="detail")
	public SubCategoryResponseBody getSubCategoryResponseBody() {
		return subCategoryResponseBody;
	}

	/**
	 * @param subCategoryResponseBody the subCategoryResponseBody to set
	 */
	public void setSubCategoryResponseBody(
			SubCategoryResponseBody subCategoryResponseBody) {
		this.subCategoryResponseBody = subCategoryResponseBody;
	}
	
}