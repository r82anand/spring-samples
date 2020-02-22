/*
 * File name		: ServletInitializer.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 22-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The Class ServletInitializer.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configure.
	 *
	 * @param application the application
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(SpringBootMongoCrudApplication.class);
	}

}
