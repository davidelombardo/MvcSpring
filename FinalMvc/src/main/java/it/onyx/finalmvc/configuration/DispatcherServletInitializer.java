package it.onyx.finalmvc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import it.onyx.finalmvc.configuration.WebApplicationWebConfigure;

public class DispatcherServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
				WebApplicationWebConfigure.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
