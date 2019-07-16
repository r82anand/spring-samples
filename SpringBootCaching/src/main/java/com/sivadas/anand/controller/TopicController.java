package com.sivadas.anand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.aop.LogExecutionTime;
import com.sivadas.anand.dto.TopicDTO;
import com.sivadas.anand.serivce.TopicService;

@RestController
public class TopicController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private TopicService topicService;

	@LogExecutionTime
	@GetMapping("/topics")
	public List<TopicDTO> getAllTopics() {

		final List<TopicDTO> topics = topicService.getAllTopics();
		topics.forEach(element -> LOGGER.info("Topic DTO = {}", element));

		return topics;

	}

}
