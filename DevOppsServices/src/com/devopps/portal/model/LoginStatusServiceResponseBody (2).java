package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"userInfo"
		})
@XmlRootElement(name = "details")
public class LoginStatusServiceResponseBody {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	protected UserDetails userInfo;

	/**
	 * @return the userInfo
	 */
	public UserDetails getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserDetails userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
