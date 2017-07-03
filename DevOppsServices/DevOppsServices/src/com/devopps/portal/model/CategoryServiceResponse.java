package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"categoryResponseHeader", "categoryResponseBody"})

public class CategoryServiceResponse {
	private ResponseHeader categoryResponseHeader;
	private CategoryResponseBody categoryResponseBody;

	/**
	 * @return the categoryResponseHeader
	 */
	@XmlElement(name="header")
	public ResponseHeader getCategoryResponseHeader() {
		return categoryResponseHeader;
	}

	/**
	 * @param categoryResponseHeader the categoryResponseHeader to set
	 */
	public void setCategoryResponseHeader(
			ResponseHeader categoryResponseHeader) {
		this.categoryResponseHeader = categoryResponseHeader;
	}

	/**
	 * @return the categoryResponseBody
	 */
	@XmlElement(name="detail")
	public CategoryResponseBody getCategoryResponseBody() {
		return categoryResponseBody;
	}

	/**
	 * @param categoryResponseBody the categoryResponseBody to set
	 */
	public void setCategoryResponseBody(CategoryResponseBody categoryResponseBody) {
		this.categoryResponseBody = categoryResponseBody;
	}
	
	
	
}
