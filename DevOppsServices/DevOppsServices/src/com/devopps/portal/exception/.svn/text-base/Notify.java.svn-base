package com.devopps.portal.exception;

import java.util.Date;
import java.util.Hashtable;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

/**
 * @author qcpi567
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Notify {
    private static String bundleName;
	private static long notifyInterval = 5*60*1000L;
	private static int notifyTimes;

	// 4 is warning, 2 is even more severe
    private static int severityLevel = DevOppsException.ERROR;
    
    private static Hashtable notifications = new Hashtable();
    
	private static String[] EXCLUDED_EXCEPTIONS_CAUSES = { 
		"View.jsp: Exception occured fetching user profile." 
	};
    
    
    private static Log log = LogFactory.getLog(Notify.class);
    
    public class Notification {
    	private Exception exception;
    	private Date lastNotified;
    	private int totalNotified;

		private String lastErrCode;
		private String lastUiErrCode;
		private String lastLevel;
		private String lastBundleName;
		private String lastSupportingInformation;
		
		private int lastSeverity;
		private String lastCauseDetail;
		
		
		

        public Notification(Exception exception) {
            this.exception = exception; 	        	
            Notification notif = (Notification)notifications.get(exception.getClass().getName());
            if(notif != null) {
            	this.totalNotified = notif.getTotalNotified() + 1;
            }
            this.lastNotified = new Date();
        }
        
        
        public Notification(Exception exception, Date lastModified, int totalNotified) {
        	this.exception = exception;
        	this.lastNotified = lastModified;
        	this.totalNotified = totalNotified;
        	
   	        if(exception != null && exception instanceof DevOppsException) 
   	        {
   	        	DevOppsException cmkException = (DevOppsException)exception;
   	    		this.lastErrCode=null;
   	    		if(cmkException.getErrCode()!=null) this.lastErrCode=cmkException.getErrCode();

   	    		this.lastUiErrCode=null;
   	    		if(cmkException.getUiErrCode()!=null)	this.lastUiErrCode=cmkException.getUiErrCode();
   	    		
   	    		this.lastLevel=null;
   	    		if(cmkException.getLevel()!=null) this.lastLevel=cmkException.getLevel();
   	    		
   	    		this.lastBundleName=null;
   	    		if(cmkException.getBundleName()!=null) this.lastBundleName=cmkException.getBundleName();
   	    		
   	    		this.lastSupportingInformation=null;
   	    		if(cmkException.getSupportingInformation()!=null) this.lastSupportingInformation=cmkException.getSupportingInformation();
   	    		
   	    		this.lastSeverity=cmkException.getSeverity();

   	    		this.lastCauseDetail=null;
   	    		if(cmkException.getMessage()!=null) this.lastCauseDetail=cmkException.getMessage();
   	    		
   	    		// cleanup
   	    		cmkException=null;
   	        }
        }
        

		/**
		 * Returns the exception.
		 * @return Exception
		 */
		public Exception getException() {
			return exception;
		}

		/**
		 * Returns the lastNotified.
		 * @return Date
		 */
		public Date getLastNotified() {
			return lastNotified;
		}

		/**
		 * Returns the totalNotified.
		 * @return int
		 */
		public int getTotalNotified() {
			return totalNotified;
		}

		/**
		 * Sets the exception.
		 * @param exception The exception to set
		 */
		public void setException(Exception exception) {
			this.exception = exception;
		}

		/**
		 * Sets the lastNotified.
		 * @param lastNotified The lastNotified to set
		 */
		public void setLastNotified(Date lastNotified) {
			this.lastNotified = lastNotified;
		}

		/**
		 * Sets the totalNotified.
		 * @param totalNotified The totalNotified to set
		 */
		public void setTotalNotified(int totalNotified) {
			this.totalNotified = totalNotified;
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("\nNotification\n");
			sb.append("Last    Notified:        " + lastNotified + "\n");
			sb.append("Total   Notified:        " + totalNotified + "\n");
			sb.append("Exception Detail:      \n" + exception.toString());
			
			return sb.toString();
		}

		/**
		 * Returns the lastBundleName.
		 * @return String
		 */
		public String getLastBundleName() {
			return lastBundleName;
		}

		/**
		 * Returns the lastCauseDetail.
		 * @return String
		 */
		public String getLastCauseDetail() {
			return lastCauseDetail;
		}

		/**
		 * Returns the lastErrCode.
		 * @return String
		 */
		public String getLastErrCode() {
			return lastErrCode;
		}

		/**
		 * Returns the lastLevel.
		 * @return String
		 */
		public String getLastLevel() {
			return lastLevel;
		}

		/**
		 * Returns the lastSeverity.
		 * @return int
		 */
		public int getLastSeverity() {
			return lastSeverity;
		}

		/**
		 * Returns the lastSupportingInformation.
		 * @return String
		 */
		public String getLastSupportingInformation() {
			return lastSupportingInformation;
		}

		/**
		 * Returns the lastUiErrCode.
		 * @return String
		 */
		public String getLastUiErrCode() {
			return lastUiErrCode;
		}

		/**
		 * Sets the lastBundleName.
		 * @param lastBundleName The lastBundleName to set
		 */
		public void setLastBundleName(String lastBundleName) {
			this.lastBundleName = lastBundleName;
		}

		/**
		 * Sets the lastCauseDetail.
		 * @param lastCauseDetail The lastCauseDetail to set
		 */
		public void setLastCauseDetail(String lastCauseDetail) {
			this.lastCauseDetail = lastCauseDetail;
		}

		/**
		 * Sets the lastErrCode.
		 * @param lastErrCode The lastErrCode to set
		 */
		public void setLastErrCode(String lastErrCode) {
			this.lastErrCode = lastErrCode;
		}

		/**
		 * Sets the lastLevel.
		 * @param lastLevel The lastLevel to set
		 */
		public void setLastLevel(String lastLevel) {
			this.lastLevel = lastLevel;
		}

		/**
		 * Sets the lastSeverity.
		 * @param lastSeverity The lastSeverity to set
		 */
		public void setLastSeverity(int lastSeverity) {
			this.lastSeverity = lastSeverity;
		}

		/**
		 * Sets the lastSupportingInformation.
		 * @param lastSupportingInformation The lastSupportingInformation to set
		 */
		public void setLastSupportingInformation(String lastSupportingInformation) {
			this.lastSupportingInformation = lastSupportingInformation;
		}

		/**
		 * Sets the lastUiErrCode.
		 * @param lastUiErrCode The lastUiErrCode to set
		 */
		public void setLastUiErrCode(String lastUiErrCode) {
			this.lastUiErrCode = lastUiErrCode;
		}

    }
    
    public boolean shouldNotify(Exception exception) {
    	return !(this.isExcludedException(exception));
/*		
		// Default to don't return an exception    	
        boolean ret = false;

		// Non Caremark exceptions always result in a notification
        if(exception != null && exception instanceof DevOppsException) 
        {
        	
        	// Cast the exception to a DevOppsException
        	DevOppsException DevOppsException = (DevOppsException)exception;

			// Get the severity level of the exception
            int severity = DevOppsException.getSeverity();

			// severityLevel = 3.  No notification is sent for severity level 4+.
            if(severity <= severityLevel) 
            {
        		Notification notif = (Notification)notifications.get(exception.getClass().getName());
        	
        		// Notify when there's not a Notification or when there is a Notification > 300,000 time units(?) old
        		if(notif != null) 
        		{
        			Date lastNotified = notif.getLastNotified();
        	
        			if(new Date().getTime() - lastNotified.getTime() > notifyInterval) 
        			{
						ret = true;
*/
						/*
        				if(DevOppsException.getErrCode()!=null && notif.getLastErrCode()==null) ret=true;
        				if(!ret && DevOppsException.getErrCode()==null && notif.getLastErrCode()!=null) ret=true;
        				if(!ret && DevOppsException.getErrCode()!=null 
        					&& notif.getLastErrCode()!=null && !DevOppsException.getErrCode().equals(notif.getLastErrCode()))	ret=true;

        				if(!ret && DevOppsException.getUiErrCode()!=null && notif.getLastUiErrCode()==null) ret=true;
        				if(!ret && DevOppsException.getUiErrCode()==null && notif.getLastUiErrCode()!=null) ret=true;
        				if(!ret && DevOppsException.getUiErrCode()!=null && notif.getLastUiErrCode()!=null
        						&& !DevOppsException.getUiErrCode().equals(notif.getLastUiErrCode())) ret=true;

        				if(!ret && DevOppsException.getLevel()!=null && notif.getLastLevel()==null) ret=true;
        				if(!ret && DevOppsException.getLevel()==null && notif.getLastLevel()!=null) ret=true;
        				if(!ret && DevOppsException.getLevel()!=null && notif.getLastLevel()!=null 
        						&& !DevOppsException.getLevel().equals(notif.getLastLevel())) ret=true;

        				if(!ret && DevOppsException.getBundleName()!=null && notif.getLastBundleName()==null) ret=true;
        				if(!ret && DevOppsException.getBundleName()==null && notif.getLastBundleName()!=null) ret=true;
        				if(!ret && DevOppsException.getBundleName()!=null && notif.getLastBundleName()!=null 
        						&& !DevOppsException.getBundleName().equals(notif.getLastBundleName())) ret=true;

        				if(!ret && DevOppsException.getSupportingInformation()!=null && notif.getLastSupportingInformation()==null) ret=true;
        				if(!ret && DevOppsException.getSupportingInformation()==null && notif.getLastSupportingInformation()!=null) ret=true;
        				if(!ret && DevOppsException.getSupportingInformation()!=null && notif.getLastSupportingInformation()!=null 
        						&& !DevOppsException.getSupportingInformation().equals(notif.getLastSupportingInformation())) ret=true;
	
						if(!ret && DevOppsException.getSeverity()!=notif.getLastSeverity()) ret=true;

        				if(!ret && DevOppsException.getMessage()!=null && notif.getLastCauseDetail()==null) ret=true;
        				if(!ret && DevOppsException.getMessage()==null && notif.getLastCauseDetail()!=null) ret=true;
        				if(!ret && DevOppsException.getMessage()!=null && notif.getLastCauseDetail()!=null 
        						&& !DevOppsException.getMessage().equals(notif.getLastCauseDetail())) ret=true;
        				*/		
/*        				
        			}
        		}
        		else 
        		{
        			ret = true;
        		}
        	}
        }
        else 
        {
        	ret = true;
        }
        	
        return ret;
*/
    }
    

    public void notify(Exception exception) {
    	notify(log, exception);
    }
	//oct-2013 release - added overloaded method so that portalWebServices logs can come into it's own log files
    public void notify(Log logger, Exception exception) {
    	if(shouldNotify(exception)) {
    		Notification notif = new Notification(exception);
    		if (((DevOppsException)exception).isDebugLevelOnly()) {
    			if (logger.isDebugEnabled()) {
    				logger.debug(notif.toString()); 
    			}
    		} else {
	    	    if (Logger.getRootLogger().getLevel().isGreaterOrEqual(Level.ERROR)) {
	    	    	((DevOppsException)exception).setLoggingRootCause(true);
	    	    }
    			logger.error(notif.toString()); 
    		}
            synchronized(notifications) {
                notifications.put(exception.getClass().getName(), notif);
            }
    	}	
    }
    
    /**
     * Determine if the exception being processed is excluded from logging
     * 
     * @param e - the Exception being processed assumed to be an instance of DevOppsException
     * @return boolean
     */
    private boolean isExcludedException(Exception e) {
    	boolean isExcluded = false;
    	String msg = null;
    	
    	try {
     		DevOppsException ce = ((DevOppsException)e);
	   		msg = ce.getCauseMessage();
	   		if (msg != null) {
	   			for (int i = 0; i < EXCLUDED_EXCEPTIONS_CAUSES.length; i++) {
	   				if (EXCLUDED_EXCEPTIONS_CAUSES[i].equalsIgnoreCase(msg)) {
	   					isExcluded = true;
	   					break;
	   				}
	   			}
	   		}
    	}catch (Throwable th) {    
    		log.debug("[EXCEPTION_HANDLER_NOTIFY]:"+th); // error encountered while handling an error
    	}

    	if (log.isDebugEnabled()) {
    		log.debug("[EXCEPTION_HANDLER_NOTIFY]:isExcluded="+isExcluded+"|"+msg);
    	}
    	return isExcluded;
    }
}
