package com.apress.spring6recipes.court.web;

import com.apress.spring6recipes.court.web.config.CourtConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CourtApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { CourtConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/", "/welcome" };
	}

}
