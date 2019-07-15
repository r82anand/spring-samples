package com.sivadas.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootJpaMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMappingApplication.class, args);
	}

}
