package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="response")
@XmlType(propOrder = {"saveNotificationsResponseHeader","saveNotificationsResponseBody"})
public class SaveNotificationServiceResponse {
	
	private ResponseHeader saveNotificationsResponseHeader;
	private SaveNotificationsResponseBody saveNotificationsResponseBody;
	/**
	 * @return the saveNotificationsResponseHeader
	 */
	@XmlElement(name="header")
	public ResponseHeader getSaveNotificationsResponseHeader() {
		return saveNotificationsResponseHeader;
	}

	/**
	 * @param saveNotificationsResponseHeader the saveNotificationsResponseHeader to set
	 */
	public void setSaveNotificationsResponseHeader(
			ResponseHeader saveNotificationsResponseHeader) {
		this.saveNotificationsResponseHeader = saveNotificationsResponseHeader;
	}

	/**
	 * @return the saveNotificationsResponseBody
	 */
	@XmlElement(name="detail")
	public SaveNotificationsResponseBody getSaveNotificationsResponseBody() {
		return saveNotificationsResponseBody;
	}

	/**
	 * @param saveNotificationsResponseBody the saveNotificationsResponseBody to set
	 */
	public void setSaveNotificationsResponseBody(
			SaveNotificationsResponseBody saveNotificationsResponseBody) {
		this.saveNotificationsResponseBody = saveNotificationsResponseBody;
	}
	
	
}
