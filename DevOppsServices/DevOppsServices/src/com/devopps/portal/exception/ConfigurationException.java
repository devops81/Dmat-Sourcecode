package com.devopps.portal.exception;

public class ConfigurationException extends RuntimeException {

     String errCode;
     String configName;	
     Throwable cause;
     int severity;
	/**
	 * Constructor for ConfigurationException.
	 */
	public ConfigurationException() {
		super();
	}

	/**
	 * Constructor for ConfigurationException.
	 * @param errCode
	 */
	public ConfigurationException(String errCode) {
		super(errCode);
	}

	/**
	 * Constructor for ConfigurationException.
	 * @param errCode
	 * @param configName
	 */
	public ConfigurationException(String errCode, String configName) {
		this(errCode);
		this.configName = configName;
	}

	/**
	 * Constructor for ConfigurationException.
	 * @param errCode
	 * @param configName
	 * @param cause
	 */
	public ConfigurationException(
		String errCode,
		String configName,
		Throwable cause) {
		this(errCode, configName);
		this.cause = cause;
	}

	/**
	 * Constructor for ConfigurationException.
	 * @param errCode
	 * @param configName
	 * @param cause
	 * @param severty
	 */
	public ConfigurationException(
		String errCode,
		String configName,
		Throwable cause,
		int severity) {
		this(errCode, configName, cause);
		this.severity = severity;
	}

}