/*
 * $Header: /home/user/cvsadm/Repository/Caremark\040common/src/com/caremark/common/util/LogFactory.java,v 1.3 2012/08/20 15:43:04 z122446-0000000-georgemeng Exp $
 * $Revision: 1.3 $
 * $Date: 2012/08/20 15:43:04 $
 *
 * ====================================================================
 *
 */
package com.devopps.portal.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import com.devopps.portal.exception.ConfigurationException;


/**
 * <p>Factory for creating {@link Log} instances, with discovery and
 * configuration features similar to that employed by standard Java APIs
 * such as JAXP.</p>
 * 
 */

public abstract class LogFactory {

 	protected static final String PORTAL_FACTORY_DEFAULT = 
 					"com.devopps.portal.util.LogFactoryImpl";

    /**
     * The previously constructed <code>LogFactory</code> instances, keyed by
     * the <code>ClassLoader</code> with which it was created.
     */
    protected static Hashtable factories = new Hashtable();


    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     *
     * @exception ConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public abstract Log getInstance(Class clazz)
        throws ConfigurationException;


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
    public abstract Log getInstance(String name)
        throws ConfigurationException;


    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param clazz Class for which a log name will be derived
     *
     * @exception ConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public static Log getLog(Class clazz)
        throws ConfigurationException {

        return (getFactory().getInstance(clazz));

    }


    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     *
     * @exception ConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public static Log getLog(String name)
        throws ConfigurationException {

        return (getFactory().getInstance(name));

    }



    /**
     *
     * @exception ConfigurationException if the implementation class is not
     *  available or cannot be instantiated.
     */
    public static LogFactory getFactory() throws ConfigurationException {

        // Identify the class loader we will be using
        ClassLoader contextClassLoader =
            (ClassLoader)AccessController.doPrivileged(
                new PrivilegedAction() {
                    public Object run() {
                        return getContextClassLoader();
                    }
                });

        // Return any previously registered factory for this class loader
        LogFactory factory = getCachedFactory(contextClassLoader);
        
        if (factory != null)
            return factory;

        // Fourth, try the fallback implementation class

        if (factory == null) {
            factory = newFactory(PORTAL_FACTORY_DEFAULT, LogFactory.class.getClassLoader());
        }
        
        if (factory != null) {
            /**
             * Always cache using context class loader..
             */
            cacheFactory(contextClassLoader, factory);
        }
        
        return factory;
    }
    
    /**
     * Check cached factories (keyed by classLoader)
     */
    private static LogFactory getCachedFactory(ClassLoader contextClassLoader)
    {
        LogFactory factory = null;
        
        if (contextClassLoader != null)
            factory = (LogFactory) factories.get(contextClassLoader);
        
        return factory;
    }

    private static void cacheFactory(ClassLoader classLoader, LogFactory factory)
    {
        if (classLoader != null && factory != null)
            factories.put(classLoader, factory);
    }
    
    /**
     * Return the thread context class loader if available.
     * Otherwise return null.
     * 
     * The thread context class loader is available for JDK 1.2
     * or later, if certain security conditions are met.
     *
     * @exception ConfigurationException if a suitable class loader
     * cannot be identified.
     */
    protected static ClassLoader getContextClassLoader()
        throws ConfigurationException
    {
        ClassLoader classLoader = null;

        try {
            // Are we running on a JDK 1.2 or later system?
            Method method = Thread.class.getMethod("getContextClassLoader", null);

            // Get the thread context class loader (if there is one)
            try {
                classLoader = (ClassLoader)method.invoke(Thread.currentThread(), null);
            } catch (IllegalAccessException e) {
                throw new ConfigurationException ("configuration.failure", null,e);
            } catch (InvocationTargetException e) {
                /**
                 * InvocationTargetException is thrown by 'invoke' when
                 * the method being invoked (getContextClassLoader) throws
                 * an exception.
                 * 
                 * getContextClassLoader() throws SecurityException when
                 * the context class loader isn't an ancestor of the
                 * calling class's class loader, or if security
                 * permissions are restricted.
                 * 
                 * In the first case (not related), we want to ignore and
                 * keep going.  We cannot help but also ignore the second
                 * with the logic below, but other calls elsewhere (to
                 * obtain a class loader) will trigger this exception where
                 * we can make a distinction.
                 */
                if (e.getTargetException() instanceof SecurityException) {
                    ;  // ignore
                } else {
                    // Capture 'e.getTargetException()' exception for details
                    // alternate: log 'e.getTargetException()', and pass back 'e'.
                    throw new ConfigurationException("configuration.failure", null,e.getTargetException());
                }
            }
        } catch (NoSuchMethodException e) {
            // Assume we are running on JDK 1.1
            classLoader = LogFactory.class.getClassLoader();
        }

        // Return the selected class loader
        return classLoader;
    }

    /**
     * Return a new instance of the specified <code>LogFactory</code>
     * implementation class, loaded by the specified class loader.
     * If that fails, try the class loader used to load this
     * (abstract) LogFactory.
     *
     * @param factoryClass Fully qualified name of the <code>LogFactory</code>
     *  implementation class
     * @param classLoader ClassLoader from which to load this class
     *
     * @exception ConfigurationException if a suitable instance
     *  cannot be created
     */
    protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader)
        throws ConfigurationException
    {
        Object result = AccessController.doPrivileged(
            new PrivilegedAction() {
                public Object run() {
                    try {
                        if (classLoader != null) {
                            try {
                                // first the given class loader param (thread class loader)
                                
                                // warning: must typecast here & allow exception
                                // to be generated/caught & recast propertly.
                                return (LogFactory)classLoader.loadClass(factoryClass).newInstance();
                            } catch (ClassNotFoundException ex) {
                                if (classLoader == LogFactory.class.getClassLoader()) {
                                    // Nothing more to try, onwards.
                                    throw ex;
                                }
                                // ignore exception, continue
                            } catch (NoClassDefFoundError e) {
                                if (classLoader == LogFactory.class.getClassLoader()) {
                                    // Nothing more to try, onwards.
                                    throw e;
                                }
                              
                            }catch(ClassCastException e){
                                
                              if (classLoader == LogFactory.class.getClassLoader()) {
                                    // Nothing more to try, onwards (bug in loader implementation).
                                    throw e;
                               }
                            }
                            // ignore exception, continue  
                        }
            
                        /* At this point, either classLoader == null, OR
                         * classLoader was unable to load factoryClass..
                         * try the class loader that loaded this class:
                         * LogFactory.getClassLoader().
                         * 
                         * Notes:
                         * a) LogFactory.class.getClassLoader() may return 'null'
                         *    if LogFactory is loaded by the bootstrap classloader.
                         * b) The Java endorsed library mechanism is instead
                         *    Class.forName(factoryClass);
                         */
                        // warning: must typecast here & allow exception
                        // to be generated/caught & recast propertly.
                        return (LogFactory)Class.forName(factoryClass).newInstance();
                    } catch (Exception e) {
                        return new ConfigurationException("configuration.failure", null, e);
                    }
                }
            });

        if (result instanceof ConfigurationException)
            throw (ConfigurationException)result;
            
        return (LogFactory)result;
    }    
    
}
