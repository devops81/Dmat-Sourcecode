package com.devopps.portal.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import com.devopps.portal.exception.ConfigurationException;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.ConfigurationException;
//import org.apache.commons.logging.LogFactory;


/**
 * <p>Concrete subclass of {@link LogFactory} that implements the
 * following algorithm to dynamically select a logging implementation
 * class to instantiate a wrapper for.</p>
 */

public class LogFactoryImpl extends LogFactory {

    // ----------------------------------------------------------- Constructors


    /**
     * Public no-arguments constructor required by the lookup mechanism.
     */
    public LogFactoryImpl() {
        super();
    }

    // ----------------------------------------------------- Instance Variables

    /**
     * Configuration attributes
     */
    protected Hashtable attributes = new Hashtable();


    /**
     * The {@link org.apache.commons.logging.Log} instances that have
     * already been created, keyed by logger name.
     */
    protected Hashtable instances = new Hashtable();


    /**
     * Name of the class implementing the Log interface.
     */
    private String logClassName;


    /**
     * The one-argument constructor of the
     * {@link org.apache.commons.logging.Log}
     * implementation class that will be used to create new instances.
     * This value is initialized by <code>getLogConstructor()</code>,
     * and then returned repeatedly.
     */
    protected Constructor logConstructor = null;


    /**
     * The signature of the Constructor to be used.
     */
    protected Class logConstructorSignature[] =
    { java.lang.String.class };


    /**
     * The one-argument <code>setLogFactory</code> method of the selected
     * {@link org.apache.commons.logging.Log} method, if it exists.
     */
    protected Method logMethod = null;


    /**
     * The signature of the <code>setLogFactory</code> method to be used.
     */
    protected Class logMethodSignature[] =
    { LogFactory.class };


    // --------------------------------------------------------- Public Methods


    /**
     * Return the configuration attribute with the specified name (if any),
     * or <code>null</code> if there is no such attribute.
     *
     * @param name Name of the attribute to return
     */
    public Object getAttribute(String name) {

        return (attributes.get(name));

    }


    /**
     * Return an array containing the names of all currently defined
     * configuration attributes.  If there are no such attributes, a zero
     * length array is returned.
     */
    public String[] getAttributeNames() {

        Vector names = new Vector();
        Enumeration keys = attributes.keys();
        while (keys.hasMoreElements()) {
            names.addElement((String) keys.nextElement());
        }
        String results[] = new String[names.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = (String) names.elementAt(i);
        }
        return (results);

    }


    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     *
     * @exception ConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public Log getInstance(Class clazz) throws ConfigurationException {

        return (getInstance(clazz.getName()));

    }


    /**
     * <p>Construct (if necessary) and return a <code>Log</code> instance,
     * using the factory's current set of configuration attributes.</p>
     *
     * <p><strong>NOTE</strong> - Depending upon the implementation of
     * the <code>LogFactory</code> you are using, the <code>Log</code>
     * instance you are returned may or may not be local to the current
     * application, and may or may not be returned again on a subsequent
     * call with the same name argument.</p>
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     *
     * @exception ConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public Log getInstance(String name) throws ConfigurationException {

        Log instance = (Log) instances.get(name);
        if (instance == null) {
            instance = newInstance(name);
            instances.put(name, instance);
        }
        return (instance);

    }


    /**
     * Release any internal references to previously created
     * {@link org.apache.commons.logging.Log}
     * instances returned by this factory.  This is useful environments
     * like servlet containers, which implement application reloading by
     * throwing away a ClassLoader.  Dangling references to objects in that
     * class loader would prevent garbage collection.
     */
    public void release() {

        instances.clear();
    }




    /**
     * Return the fully qualified Java classname of the {@link Log}
     * implementation we will be using.
     */
    protected String getLogClassName() {

        // Return the previously identified class name (if any)
        if (logClassName != null) {
            return logClassName;
        }

        if ((logClassName == null) && isLog4JAvailable()) {
            logClassName = "com.devopps.portal.util.Log";
        }

        if ((logClassName == null) && isJdk14Available()) {
            logClassName = "org.apache.commons.logging.impl.Jdk14Logger";
        }

        if (logClassName == null) {
            logClassName = "org.apache.commons.logging.impl.SimpleLog";
        }

        return (logClassName);

    }


    /**
     * <p>Return the <code>Constructor</code> that can be called to instantiate
     * new {@link org.apache.commons.logging.Log} instances.</p>
     *
     * <p><strong>IMPLEMENTATION NOTE</strong> - Race conditions caused by
     * calling this method from more than one thread are ignored, because
     * the same <code>Constructor</code> instance will ultimately be derived
     * in all circumstances.</p>
     *
     * @exception ConfigurationException if a suitable constructor
     *  cannot be returned
     */
    protected Constructor getLogConstructor()
        throws ConfigurationException {

        // Return the previously identified Constructor (if any)
        if (logConstructor != null) {
            return logConstructor;
        }

        String logClassName = getLogClassName();

        // Attempt to load the Log implementation class
        Class logClass = null;
        try {
            logClass = loadClass(logClassName);
            if (logClass == null) {
                throw new ConfigurationException
                    ("No suitable Log implementation for " + logClassName);
            }
            if (!Log.class.isAssignableFrom(logClass)) {
                throw new ConfigurationException
                    ("Class " + logClassName + " does not implement Log");
            }
        } catch (Throwable t) {
            throw new ConfigurationException("configuration.failure", null,t);
        }

        // Identify the <code>setLogFactory</code> method (if there is one)
        try {
            logMethod = logClass.getMethod("setLogFactory",
                                           logMethodSignature);
        } catch (Throwable t) {
            logMethod = null;
        }

        // Identify the corresponding constructor to be used
        try {
            logConstructor = logClass.getConstructor(logConstructorSignature);
            return (logConstructor);
        } catch (Throwable t) {
            throw new ConfigurationException("configuration.failure", null, t);
  
        }
    }


    /**
     * MUST KEEP THIS METHOD PRIVATE.
     *
     * <p>Exposing this method outside of
     * <code>org.apache.commons.logging.LogFactoryImpl</code>
     * will create a security violation:
     * This method uses <code>AccessController.doPrivileged()</code>.
     * </p>
     *
     * Load a class, try first the thread class loader, and
     * if it fails use the loader that loaded this class.
     */
    private static Class loadClass( final String name )
        throws ClassNotFoundException
    {
        Object result = AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    ClassLoader threadCL = getContextClassLoader();
                    if (threadCL != null) {
                        try {
                            return threadCL.loadClass(name);
                        } catch( ClassNotFoundException ex ) {
                            // ignore
                        }
                    }
                    try {
                        return Class.forName( name );
                    } catch (ClassNotFoundException e) {
                        return e;
                    }
                }
            });

        if (result instanceof Class)
            return (Class)result;

        throw (ClassNotFoundException)result;
    }


    /**
     * Is <em>JDK 1.4 or later</em> logging available?
     */
    protected boolean isJdk14Available() {

        try {
            loadClass("java.util.logging.Logger");
            loadClass("org.apache.commons.logging.impl.Jdk14Logger");
            return (true);
        } catch (Throwable t) {
            return (false);
        }
    }


    /**
     * Is a <em>Log4J</em> implementation available?
     */
    protected boolean isLog4JAvailable() {

        try {
            loadClass("org.apache.log4j.Logger");
            //loadClass("org.apache.commons.logging.impl.Log4JLogger");
            return (true);
        } catch (Throwable t) {
            return (false);
        }
    }


    /**
     * Create and return a new {@link org.apache.commons.logging.Log}
     * instance for the specified name.
     *
     * @param name Name of the new logger
     *
     * @exception ConfigurationException if a new instance cannot
     *  be created
     */
    protected Log newInstance(String name) throws ConfigurationException {

        Log instance = null;
        try {
            Object params[] = new Object[1];
            params[0] = name;
            instance = (Log) getLogConstructor().newInstance(params);
            if (logMethod != null) {
                params[0] = this;
                logMethod.invoke(instance, params);
            }
            return (instance);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new ConfigurationException("configuration.failure", null, t);

        }

    }

}
