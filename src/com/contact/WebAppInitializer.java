package com.contact;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContex = new AnnotationConfigWebApplicationContext();
		appContex.register(SpringMvcConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContex));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		// Testing Jenkinks Commit
		//Test tomcat deployment
	}

}
