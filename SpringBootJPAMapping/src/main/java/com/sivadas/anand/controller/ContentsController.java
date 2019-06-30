package com.sivadas.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.serivce.ContentsService;

@RestController
public class ContentsController {

	@Autowired
	private ContentsService service;
	
	@GetMapping("/contents")
	public List<ContentsDTO> getAllContents() {
		return service.getAllContents();
	}
	
}
