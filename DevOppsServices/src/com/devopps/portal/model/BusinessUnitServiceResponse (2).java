package com.devopps.portal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="response")
@XmlType(propOrder = {"businessUnitResponseHeader", "businessUnitResponseBody"})
public class BusinessUnitServiceResponse {
	
		private ResponseHeader businessUnitResponseHeader;
		private BusinessUnitResponseBody businessUnitResponseBody;
		
		/**
		 * @return the businessUnitResponseHeader
		 */
		@XmlElement(name="header")
		public ResponseHeader getBusinessUnitResponseHeader() {
			return businessUnitResponseHeader;
		}
		/**
		 * @param businessUnitResponseHeader the businessUnitResponseHeader to set
		 */
		public void setBusinessUnitResponseHeader(
				ResponseHeader businessUnitResponseHeader) {
			this.businessUnitResponseHeader = businessUnitResponseHeader;
		}
		/**
		 * @return the businessUnitResponseBody
		 */
		@XmlElement(name="detail")
		public BusinessUnitResponseBody getBusinessUnitResponseBody() {
			return businessUnitResponseBody;
		}
		/**
		 * @param businessUnitResponseBody the businessUnitResponseBody to set
		 */
		public void setBusinessUnitResponseBody(
				BusinessUnitResponseBody businessUnitResponseBody) {
			this.businessUnitResponseBody = businessUnitResponseBody;
		}
		
}
