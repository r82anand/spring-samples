package com.sivadas.anand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sivadas.anand.service.RandonQuoteService;

@Controller
public class HelloWorldController {

	@RequestMapping("/")
	public String sayHello(Model model) {
		
		model.addAttribute("quote", RandonQuoteService.getRandomQuoteOfTheDay());
		
		return "helloworld";
	}
	
}
