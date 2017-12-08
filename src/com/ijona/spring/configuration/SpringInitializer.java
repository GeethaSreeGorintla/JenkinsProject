package com.ijona.spring.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInitializer implements WebApplicationInitializer {

	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
	
		
		 int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
		  String TMP_FOLDER = "/tmp"; 
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(IjonaSpringConfiguration.class);
		ctx.setServletContext(container);
	
		 container.addListener(new SessionListener());
		ServletRegistration.Dynamic servlet = container.addServlet(
				"dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		 MultipartConfigElement multipartConfigElement = new MultipartConfigElement( TMP_FOLDER,
		          MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
		         
		 servlet.setMultipartConfig(multipartConfigElement);	
		
	}
	
	
}
