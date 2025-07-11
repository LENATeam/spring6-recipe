package com.apress.spring6recipes.court.web;

import com.apress.spring6recipes.court.config.I18NConfiguration;
import com.apress.spring6recipes.court.config.InterceptorConfiguration;
import com.apress.spring6recipes.court.config.ViewResolverConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * {@link org.springframework.web.WebApplicationInitializer} implementation to bootstrap
 * the application.
 */
public class CourtWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ViewResolverConfiguration.class, I18NConfiguration.class, InterceptorConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
