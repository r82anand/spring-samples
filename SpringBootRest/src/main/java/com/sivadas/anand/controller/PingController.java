package com.sivadas.anand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.service.PingService;

@RestController
public class PingController {

	@Autowired
	private PingService pingService;

	@GetMapping(path="/ping")
	public String ping() {
		return pingService.getPingMessage();
	}
	
	
}
