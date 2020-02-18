/*
 * File name		: AppliConfig.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 19-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sivadas.anand.filter.HelloFilter;
import com.sivadas.anand.filter.MessageFilter;
import com.sivadas.anand.filter.SalutationFilter;

/**
 * The Class AppliConfig.
 */
@Configuration
public class AppliConfig {

	@Autowired
	private HelloFilter helloFilter;

	@Autowired
	private MessageFilter messageFilter;

	@Autowired
	private SalutationFilter salutationFilter;

	/**
	 * Hello filter registration.
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public FilterRegistrationBean<HelloFilter> helloFilterRegistration() {

	    final FilterRegistrationBean<HelloFilter> registration = new FilterRegistrationBean<>();
	    registration.setFilter(helloFilter);
	    registration.setName("hellFilter");
	    registration.setOrder(35);

	    return registration;
	}

	/**
	 * Message filter registration.
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public FilterRegistrationBean<MessageFilter> messageFilterRegistration() {

	    final FilterRegistrationBean<MessageFilter> registration = new FilterRegistrationBean<>();
	    registration.setFilter(messageFilter);
	    registration.setName("messFilter");
	    registration.setOrder(25);

	    return registration;
	}

	/**
	 * Some filter registration.
	 *
	 * @return the filter registration bean
	 */
	@Bean
	public FilterRegistrationBean<SalutationFilter> someFilterRegistration() {

	    final FilterRegistrationBean<SalutationFilter> registration = new FilterRegistrationBean<>();
	    registration.setFilter(salutationFilter);
	    registration.setName("saluteFilter");
	    registration.setOrder(50);

	    return registration;
	}

}
