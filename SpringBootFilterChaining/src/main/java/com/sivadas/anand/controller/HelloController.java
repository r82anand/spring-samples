/*
 * File name		: HelloController.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 19-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.dto.Greeting;

/**
 * The Class HelloController.
 */
@RestController
public class HelloController {

	private static String TEMPLATE = "Hello, %s";
	private final AtomicLong sequence = new AtomicLong();

	/**
	 * Gets the greeted.
	 *
	 * @param name the name
	 * @return the greeted
	 */
	@GetMapping(value = "/greet")
	public Greeting getGreeted(@RequestParam(value = "name", defaultValue = "World") final String name) {

		return new Greeting(sequence.incrementAndGet(), String.format(TEMPLATE, name));
	}

}
