package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "showDistinctVals"
})
@XmlRootElement(name = "application")
public class ApplicationRequestBody {

	private boolean showDistinctVals;

	/**
	 * @return the showDistinctVals
	 */
	public boolean isShowDistinctVals() {
		return showDistinctVals;
	}

	/**
	 * @param showDistinctVals the showDistinctVals to set
	 */
	public void setShowDistinctVals(boolean showDistinctVals) {
		this.showDistinctVals = showDistinctVals;
	}
	
	
}
