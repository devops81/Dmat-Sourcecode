package com.devopps.portal.exception;

import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

public class ExceptionHandler {
	private static String bundleName;
	
	private static Log logger = LogFactory.getLog(ExceptionHandler.class);
	
	private void init() {
	}
	
    public static String handle(Exception e) {
    	return handle(LogFactory.getLog(Notify.class), e);
    }
	//oct-2013 release - added overloaded method so that portalWebServices logs can come into it's own log files
    public static String handle(Log log, Exception e) {
    	String ret = null;	
    	try {
    		boolean isCaremarkException = isCaremarkException(e);
   			new Notify().notify(log, isCaremarkException ? e : new DevOppsException(null, null, e));
    	    ret = getUiErrCode(e);
    	}catch (Throwable th) {    
    	    // error encountered while handling an error
    	}
    	
    	return ret;
    }
    
    public static void log(Exception e) {
    	if(e instanceof DevOppsException) {
    	}
    	else {
    	}
    }
    
    public static void notify(Exception e) {
    	new Notify().notify(e);
    }
    
    public static String getUiErrMessage(Exception e) {
        String ret = null;
        // put code to get ui message from bundle.
        return ret;	
    }
    public static String getUiErrCode(Exception e) {
    	String uiErrCode = null;
    	if(isCaremarkException(e)) {
    		//String errCode = ((CaremarkException)e).getUiErrCode();
    		DevOppsException cme = (DevOppsException)e;
    		int severity = cme.getSeverity();
    		if(severity == DevOppsException.EMERGENCY
    		|| severity == DevOppsException.ALERT
    		|| severity == DevOppsException.CRITICAL) {
    		    uiErrCode = "error.portal";
    		}
    		else if(severity == DevOppsException.ERROR) {
    			//uiErrCode = "error.system";
    			uiErrCode = "error.portlet";
    		}
    		else if(severity == DevOppsException.WARNING) {
    			uiErrCode = "warn.portlet";
    		}
    		else {
    			uiErrCode = "info.portlet";    			
    		}
    	}
    	else if(isSystemException(e)) {
    		uiErrCode = "error.system";
    	}
    	else {
    	    uiErrCode = "error.portlet";	
    	}
    	
    	return uiErrCode;
    }
    
    public static boolean isCaremarkException(Exception e) {
    	boolean ret = false;
    	if( e instanceof DevOppsException) {
    		ret = true;
    	}        
        return ret;
    }
    
    public static boolean isSystemException(Exception e) {
    	boolean ret = false;
    	if(e != null) {
    		String eName = e.getClass().getName();
    		if("com.caremark.portal.exception.SystemException".equals(eName) ) {
    			ret = true;
    		}
    	}        
        return ret;
    }
    
    /**
     * Determines if the input exception is an instance of - com.caremark.common.exception.TagHandlerException
     * 
     * @param e - The exception to test
     * @return boolean
     */
    public static boolean isTagHandlerException(Exception e) {
    	boolean ret = false;
    	if(e != null) {
    		String eName = e.getClass().getName();
    		if("com.caremark.common.exception.TagHandlerException".equals(eName) ) {
    			ret = true;
    		}
    	}        
        return ret;
    }
}


