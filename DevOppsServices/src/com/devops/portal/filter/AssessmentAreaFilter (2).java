package com.devops.portal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;

public class AssessmentAreaFilter implements Filter {
	
	private static final Log LOGGER = LogFactory.getLog(AssessmentAreaFilter.class);

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	    	LOGGER.debug("Init Method");
	    }

	    @Override
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	    	LOGGER.info("Adding Access Control Response Headers");
	    	
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	        /*response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	        response.setHeader( "Content-Type", "application/xml");*/
	        

	        
	        /*response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Credentials", "true");
	        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
	        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	        */
	        filterChain.doFilter(servletRequest, response);
	    }

	    @Override
	    public void destroy() {

	    }

}
