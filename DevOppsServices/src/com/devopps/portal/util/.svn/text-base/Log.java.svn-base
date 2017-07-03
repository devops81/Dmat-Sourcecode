package com.devopps.portal.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;



//import org.apache.commons.logging.Log;

/**
 * @author qcpi367
 *
 * $Header: /home/user/cvsadm/Repository/Caremark\040common/src/com/caremark/common/util/Log.java,v 1.3 2012/08/20 15:43:04 z122446-0000000-georgemeng Exp $
 * $Revision: 1.3 $
 * $Date: 2012/08/20 15:43:04 $
 *
 */
public class Log {


/**
 * <p>Implementation of {@link PortalLog} that maps directly to a Log4J
 * <strong>Logger</strong>.  Initial configuration of the corresponding
 * Logger instances should be done in the usual manner, as outlined in
 * the Log4J documentation.</p>
 *
 * @author Jun Liu
 * @version $Id: Log.java,v 1.3 2012/08/20 15:43:04 z122446-0000000-georgemeng Exp $
 */

    // ------------------------------------------------------------- Attributes

    /** The fully qualified name of the Log4JLogger class. */
    private static final String FQCN = Log.class.getName();
    
    /** Log to this logger */
    private Logger logger = null;


    // ------------------------------------------------------------ Constructor

    public Log() {
    }


    /**
     * Base constructor
     */
    public Log(String name) {
        this.logger=Logger.getLogger(name);
    }

    /** For use with a log4j factory
     */
    public Log(Logger logger ) {
        this.logger=logger;
    }


    // ---------------------------------------------------------- Implmentation


    /**
     * Log a message to the Log4j Logger with <code>TRACE</code> priority.
     * Currently logs to <code>DEBUG</code> level in Log4J.
     */
    public void trace(Object message) {
    	if( isTraceEnabled() )
        	logger.log(FQCN, Priority.DEBUG, message, null);
    }


    /**
     * Log an error to the Log4j Logger with <code>TRACE</code> priority.
     * Currently logs to <code>DEBUG</code> level in Log4J.
     */
    public void trace(Object message, Throwable t) {
    	if( isTraceEnabled() )
        	logger.log(FQCN, Priority.DEBUG, message, t );
    }


    /**
     * Log a message to the Log4j Logger with <code>DEBUG</code> priority.
     */
    public void debug(Object message) {
    	if (isDebugEnabled()) {
    	    logger.log(FQCN, Priority.DEBUG, message, null);
    	}
    }

    /**
     * Log an error to the Log4j Logger with <code>DEBUG</code> priority.
     */
    public void debug(Object message, Throwable t) {
        if( isDebugEnabled() )
        	logger.log(FQCN, Priority.DEBUG, message, t );
    }


    /**
     * Log a message to the Log4j Logger with <code>INFO</code> priority.
     */
    public void info(Object message) {
        if( isInfoEnabled() )
        	logger.log(FQCN, Priority.INFO, message, null );
    }


    /**
     * Log an error to the Log4j Logger with <code>INFO</code> priority.
     */
    public void info(Object message, Throwable t) {
    	if( isInfoEnabled() )
        	logger.log(FQCN, Priority.INFO, message, t );
    }


    /**
     * Log a message to the Log4j Logger with <code>WARN</code> priority.
     */
    public void warn(Object message) {
    	if( isWarnEnabled() )
        	logger.log(FQCN, Priority.WARN, message, null );
    }


    /**
     * Log an error to the Log4j Logger with <code>WARN</code> priority.
     */
    public void warn(Object message, Throwable t) {
        if( isWarnEnabled() )
        	logger.log(FQCN, Priority.WARN, message, t );
    }


    /**
     * Log a message to the Log4j Logger with <code>ERROR</code> priority.
     */
    public void error(Object message) {
        if (isErrorEnabled()) {
     	    try {
     	   	    String msg = null;
	    	    if (Logger.getRootLogger().getLevel().isGreaterOrEqual(Level.ERROR)) {
	    	        
	    	        //default value as there is no JNDI entry
	    	        int logMsgLength = 1024;
	    	        if (logMsgLength > ((String) message).length()) {
	    	            msg = (String) message;    
	    	        }
	    	        else {
	    	            msg = ((String) message).substring(0, logMsgLength);
	    	        }
	    	        logger.log(FQCN, Priority.ERROR, msg, null);
	    	    }
	    	    else {
	    	        logger.log(FQCN, Priority.ERROR, message, null);
	    	    }
    	    }
    	    catch (Throwable t) {
    	        logger.log(FQCN, Priority.ERROR, message, null);    
    	    }
        }
    }


    /**
     * Log an error to the Log4j Logger with <code>ERROR</code> priority.
     */
    public void error(Object message, Throwable t) {
        if( isErrorEnabled() )
        	logger.log(FQCN, Priority.ERROR, message, t );
    }


    /**
     * Log a message to the Log4j Logger with <code>FATAL</code> priority.
     */
    public void fatal(Object message) {
        if( isFatalEnabled() )
        	logger.log(FQCN, Priority.FATAL, message, null );
    }


    /**
     * Log an error to the Log4j Logger with <code>FATAL</code> priority.
     */
    public void fatal(Object message, Throwable t) {
        if( isFatalEnabled() )
        	logger.log(FQCN, Priority.FATAL, message, t );
    }


    /**
     * Return the native Logger instance we are using.
     */
    public Logger getLogger() {
        return (this.logger);
    }


    /**
     * Check whether the Log4j Logger used is enabled for <code>DEBUG</code> priority.
     */
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }


     /**
     * Check whether the Log4j Logger used is enabled for <code>ERROR</code> priority.
     */
    public boolean isErrorEnabled() {
        return logger.isEnabledFor(Priority.ERROR);
    }


    /**
     * Check whether the Log4j Logger used is enabled for <code>FATAL</code> priority.
     */
    public boolean isFatalEnabled() {
        return logger.isEnabledFor(Priority.FATAL);
    }


    /**
     * Check whether the Log4j Logger used is enabled for <code>INFO</code> priority.
     */
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }


    /**
     * Check whether the Log4j Logger used is enabled for <code>TRACE</code> priority.
     * For Log4J, this returns the value of <code>isDebugEnabled()</code>
     */
    public boolean isTraceEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * Check whether the Log4j Logger used is enabled for <code>WARN</code> priority.
     */
    public boolean isWarnEnabled() {
        return logger.isEnabledFor(Priority.WARN);
    }
}
