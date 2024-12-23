package com.demo.interest_calculator.config;

import com.demo.interest_calculator.entity.Calculator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ResultRestConfig implements RepositoryRestConfigurer {

	/*@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

		// disable HTTP methods for Product: PUT, POST, DELETE and PATCH
		config.getExposureConfiguration()
				.forDomainType(Calculator.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}*/
}
