package com.sivadas.anand.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PingService {

	@Value("${app.ownername:World}")
	private String name;
	
	public String getPingMessage() {
		return "Hello, " + name;
	}
	
}
