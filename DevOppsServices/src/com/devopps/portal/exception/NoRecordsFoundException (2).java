package com.devopps.portal.exception;

public class NoRecordsFoundException extends Exception {
	
private static final long serialVersionUID = -949985186966123695L;
	

	protected String serviceId;
	private String errorMessage;
	
	/**
	 * Constructor for DuplicateAssessmentAreasException
	 */
	public NoRecordsFoundException() {
		super();
	}
	
	/**
	 * Constructor for ControlledSubstanceException
	 * @param errCode
	 */
	public NoRecordsFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * Returns the serviceId.
	 * @return String
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * Sets the serviceId.
	 * @param serviceId The serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("serviceId = " + serviceId + "\n");
		stringBuilder.append(super.toString());
		return stringBuilder.toString();
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
