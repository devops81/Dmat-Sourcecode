package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"saveApplicationResponseHeader", "saveApplicationResponseBody"})
public class SaveApplicationServiceResponse {
	
	private SaveApplicationResponseHeader saveApplicationResponseHeader;
	private SaveApplicationResponseBody saveApplicationResponseBody;
	
	/**
	 * @return the saveApplicationResponseHeader
	 */
	@XmlElement(name="header")
	public SaveApplicationResponseHeader getSaveApplicationResponseHeader() {
		return saveApplicationResponseHeader;
	}
	/**
	 * @param saveApplicationResponseHeader the saveApplicationResponseHeader to set
	 */
	public void setSaveApplicationResponseHeader(
			SaveApplicationResponseHeader saveApplicationResponseHeader) {
		this.saveApplicationResponseHeader = saveApplicationResponseHeader;
	}
	/**
	 * @return the saveApplicationResponseBody
	 */
	@XmlElement(name="detail")
	public SaveApplicationResponseBody getSaveApplicationResponseBody() {
		return saveApplicationResponseBody;
	}
	/**
	 * @param saveApplicationResponseBody the saveApplicationResponseBody to set
	 */
	public void setSaveApplicationResponseBody(
			SaveApplicationResponseBody saveApplicationResponseBody) {
		this.saveApplicationResponseBody = saveApplicationResponseBody;
	}
	
	
}
