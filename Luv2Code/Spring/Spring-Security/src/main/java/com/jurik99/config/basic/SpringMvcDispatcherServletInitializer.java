package com.jurik99.config.basic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * WEB APP INITIALIZER
 *
 * 1) Spring MVC provides support for web app initialization
 * 2) Makes sure your code is automatically detected
 * 3) Your code is used to initialize the servlet container
 */
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// --- our config class created for SERVLET (to handle view .jsp files) ---
		return new Class[] {SpringServletAndWebXmlConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// --- default mapping for DISPATCHER SERVLET ---
		return new String[] {"/"};
	}
}
