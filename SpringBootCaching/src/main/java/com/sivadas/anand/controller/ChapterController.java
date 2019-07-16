package com.sivadas.anand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.aop.LogExecutionTime;
import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.serivce.ChapterService;

@RestController
public class ChapterController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ChapterController.class);

	@Autowired
	private ChapterService service;

	@LogExecutionTime
	@GetMapping("/chapters")
	public List<ChapterDTO> getAllChapters() {

		final List<ChapterDTO> allChapeters = service.getAllChapters();
		allChapeters.forEach(element -> {
			LOGGER.info("Chapter DTO = {}", element);
		});

		return allChapeters;
	}

}
