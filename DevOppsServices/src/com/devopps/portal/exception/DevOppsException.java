
package com.devopps.portal.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class DevOppsException extends Exception {
	private static final int ERROR_TOP_STACK_LIMIT = 5;
	
	public static final int EMERGENCY     = 0;  // system unusable
	public static final int ALERT         = 1; // immediate action needed
	public static final int CRITICAL      = 2; // critical condition
	public static final int ERROR         = 3; // error condition
	public static final int WARNING       = 4; // warning condition
	public static final int NOTIFICATION  = 5; // normal but significate condition
	public static final int INFORMATIONAL = 6; // info message to report the exception
	
	private boolean debugLevelOnly; // Indicates that this exception should be logged at a debug lvl only, regardless of the logging level
	
	private String errCode;
	private String uiErrCode;
	private String level;
	private String bundleName;
	private String trackingNumber;
	private String generalInformation; // general or common data specific to the context of this exception
	private String supportingInformation;
	
	private int severity;
//	private Throwable cause;
	private Date dateGenerated = new Date();
	
	private String stackTrace;
	private boolean loggingRootCause = false;
	
    /**
     * Init
     */
    private void init() {
    	
    }
	/**
	 * Constructor for CaremarkException.
	 */
	public DevOppsException() {
		super();
	    init();
	}

	/**
	 * Constructor for CaremarkException.
	 * @param errCode
	 */
	public DevOppsException(String errCode) {
		this();
		this.errCode = errCode;
	}
	
	/**
	 * Constructor for CaremarkException.
	 * @param errCode
	 * @param uiErrCode
	 */
	public DevOppsException(String errCode, String uiErrCode) {
		this(errCode);
		this.uiErrCode = uiErrCode;
		
	}
		
	/**
	 * Constructor for CaremarkException.
	 * @param errCode
	 * @param uiErrCode
	 * @param cause
	 */
	public DevOppsException(String errCode, String uiErrCode, Throwable cause) {
		this(errCode, uiErrCode);
		this.initCause(cause);
		
	}
	
    /**
	 * Constructor for CaremarkException.
	 * @param errCode
	 * @param uiErrCode
	 * @param cause
	 * @param serverty
	 */
	public DevOppsException(String errCode, String uiErrCode, Throwable cause, int severity) {
		this(errCode, uiErrCode, cause);
		this.severity = severity;
		
	}

	/**
	 * Returns the bundleName.
	 * @return String
	 */
	public String getBundleName() {
		return bundleName;
	}

	/**
	 * Returns the errCode.
	 * @return String
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * Returns the level.
	 * @return String
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Returns the severity.
	 * @return int
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * Returns the uiErrCode.
	 * @return String
	 */
	public String getUiErrCode() {
		return uiErrCode;
	}

	/**
	 * Sets the bundleName.
	 * @param bundleName The bundleName to set
	 */
	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	/**
	 * Sets the errCode.
	 * @param errCode The errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * Sets the level.
	 * @param level The level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Sets the severity.
	 * @param severity The severity to set
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	/**
	 * Sets the uiErrCode.
	 * @param uiErrCode The uiErrCode to set
	 */
	public void setUiErrCode(String uiErrCode) {
		this.uiErrCode = uiErrCode;
	}

    public String getToString() 
    {
    	StringBuffer sb = new StringBuffer();
    	if(getCause() != null) 
    	{
 			try
 			{
 				sb.append(getCause().toString());
 			}
 			catch (Exception ex)
 			{
 				sb.append("An Exception was caught while invoking the cause toString() method. Exception="+ex);
 			}
 			catch (Throwable th)
 			{
 				sb.append("A Throwable was caught while invoking the cause toString() method. Throwable="+th);				
 			}			
    	} else {
    		sb.append("cause is null so the toString() could not be invoked");
    	}	
    	return sb.toString();
    }
        
	/**
	 * Returns the trackingNumber.
	 * @return String
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getSupportingInformation() {
		return supportingInformation;
	}
	
	public void setSupportingInformation(String supportingInformation) {
		this.supportingInformation = supportingInformation;
	}		

	/**
	 * Returns general/common information specific to the context of this exception.
	 * 
	 * A null value may be returned
	 * 
	 * @return the generalInformation
	 */
	public String getGeneralInformation() {
		return generalInformation;
	}
	
	/**
	 * Sets the value of the general/common information
	 * 
	 * @param generalInformation the generalInformation to set
	 */
	public void setGeneralInformation(String generalInformation) {
		this.generalInformation = generalInformation;
	}	
	
	/**
	 * Sets the trackingNumber.
	 * @param trackingNumber The trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

    public static String getSeverityString(int severity) {
    	String ret = "UNKNOWN";
    	if(severity == EMERGENCY) {
    		ret = "EMERGENCY";
    	}
    	else if(severity == ALERT) {
    		ret = "ALERT";
    	}
    	else if(severity == CRITICAL) {
    		ret = "CRITICAL";
    	}
    	else if(severity == ERROR) {
    	    ret = "ERROR";
    	}
    	else if(severity == NOTIFICATION) {
            ret = "NOTIFICATION";
    	}
    	else if(severity == INFORMATIONAL) {
    		ret = "INFORMATIONAL";
    	}
    	return ret;	
    }
    
    public String toString() 
    {
        StringBuffer sb = new StringBuffer();

        try
		{
        	sb.append("exceptionName = " + getClass().getName() + "\n");
        	sb.append("exceptionMessage = " + getMessage() + "\n");
        	sb.append("errCode = " + errCode + "\n");
        	sb.append("uiErrCode = " + uiErrCode + "\n");
        	sb.append("severity = " + getSeverityString(severity) + "\n");
        	sb.append("level = " + level + "\n");
        	sb.append("trackingNumber = " + trackingNumber + "\n");
        	sb.append("dateGenerated = " + dateGenerated + "\n");
        	sb.append("general information = " + generalInformation + "\n");
        	sb.append("supporting information = " + supportingInformation + "\n");
        	Throwable t = getCause();
	        sb.append("causeMessage = " + ((t != null) ? t.getMessage() : "NULL") + "\n");
	        sb.append("cause.toString() = " + getToString() + "\n");

        	if (isLoggingRootCause()) {
        		sb.append(getRootCauseStack());
        	} else {
    	        sb.append("stack trace = ");
    	        
        		StackTraceElement[] stackElements = getStackTrace();
	        	sb.append(stackElements[0].toString() + "\n");
	        	for (int i = 1; i < stackElements.length; i++) {
	        		sb.append("\tat "+stackElements[i].toString() + "\n");
	        	}
	
	        	if ( getCause() != null ){
	        		if ( getCause().getStackTrace() != null ) {
	        			sb.append("Caused by: ");
	        			final StringWriter result = new StringWriter();
	        			final PrintWriter printWriter = new PrintWriter( result );
	        			getCause().printStackTrace( printWriter );
	        			printWriter.flush();
	        			sb.append(result.toString());
	        		}
	        	}
        	}
		}
        catch(Throwable th)
		{
        	sb.append("CaremarkException: exception while formatting toString(): "+th);
		}	

        return sb.toString();
    }
    
    /**
     * Returns the cause message from this exception 
     * 
     * @return the cause message
     */
    public String getCauseMessage() {
    	Throwable t = getCause();
    	return ((t != null) ? t.getMessage() : null);
    }
    
	/**
	 * @return the debugLevelOnly
	 */
	public boolean isDebugLevelOnly() {
		return debugLevelOnly;
	}
	
	/**
	 * @param debugLevelOnly the debugLevelOnly to set
	 */
	public void setDebugLevelOnly(boolean debugLevelOnly) {
		this.debugLevelOnly = debugLevelOnly;
	}

	public boolean isLoggingRootCause() {
		return loggingRootCause;
	}
	
	public void setLoggingRootCause(boolean loggingRootCause) {
		this.loggingRootCause = loggingRootCause;
	}
	
	/* 
	 * Returns only a few lines of the top stack followed by the root exception stack 
	 * to ensure the root cause is not truncated by the 4096 character limit when the 
	 * log4j root logger is at Level.ERROR (such as in PROD).
	 */
	protected String getRootCauseStack() {
		StringBuffer sb = new StringBuffer();

		// determine the root cause
		Throwable t = this;
		while (t.getCause() != null) {
			t = t.getCause();
		}

		// print only a few lines of the top exception stack if there is a root cause
		if (t != this) {
			sb.append("top stack trace:\n");
			StackTraceElement[] topStack = getStackTrace();
			for (int i=0; i<ERROR_TOP_STACK_LIMIT; i++) {
				sb.append("\tat " + topStack[i] + "\n");
			}
			sb.append("\t... " + (topStack.length - ERROR_TOP_STACK_LIMIT) + " more\n");
		}
		
		// print root cause class and message
		sb.append("root cause: ");
		if (t instanceof DevOppsException) {   
			sb.append(t.getClass().getName());
			sb.append(t.getMessage() != null ? ": " + t.getMessage() : "").append("\n");
		} else {
			sb.append(t.toString() + "\n");
		}
		
		// print root cause stack
		StackTraceElement[] stack = t.getStackTrace();
		for (int i=0; i<stack.length; i++) {
			sb.append("\tat " + stack[i] + "\n");
		}

		return sb.toString();
	}

}