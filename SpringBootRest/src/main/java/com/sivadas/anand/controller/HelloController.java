package com.sivadas.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.service.PingService;

@RestController
@Profile(value="prod")
public class HelloController {

	@Autowired
	private PingService pingService;
	
	@GetMapping(path="/hello")
	public String sayHello() {
		return pingService.getPingMessage();
	}
	
}
