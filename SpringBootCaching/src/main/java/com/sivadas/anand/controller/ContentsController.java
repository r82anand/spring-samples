package com.sivadas.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.aop.LogExecutionTime;
import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.serivce.ContentsService;

@RestController
public class ContentsController {

	@Autowired
	private ContentsService service;

	@LogExecutionTime
	@GetMapping("/contents")
	public List<ContentsDTO> getAllContents() {
		return service.getAllContents();
	}

	@LogExecutionTime
	@GetMapping("/content/{id}")
	public ContentsDTO getContent(@PathVariable final Long id) {
		return service.getContentById(id);
	}

	@LogExecutionTime
	@PostMapping(path = "/content/save", consumes = "application/json", produces = "application/json")
	public ContentsDTO saveContent(@RequestBody final ContentsDTO content) {
		return service.saveContent(content);
	}

}
