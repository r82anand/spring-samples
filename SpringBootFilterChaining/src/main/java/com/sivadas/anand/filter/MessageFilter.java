/*
 * File name		: MessageFilter.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 19-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class MessageFilter.
 */
@Component
public class MessageFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageFilter.class);

	/**
	 * Do filter.
	 *
	 * @param request the request
	 * @param response the response
	 * @param chain the chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(request, response);
		LOGGER.info("Message from MessageFilter!");
	}

}
