package com.sivadas.anand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.dto.TopicDTO;
import com.sivadas.anand.serivce.TopicService;

@RestController
public class TopicController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private TopicService topicService;

	@GetMapping("/topics")
	public List<TopicDTO> getAllTopics() {

		final List<TopicDTO> topics = topicService.getAllTopics();
		topics.forEach(element -> LOGGER.info("Topic DTO = {}", element));

		return topics;

	}

	@GetMapping("/topic/{id}")
	public TopicDTO getTopic(@PathVariable final Long id) {

		final TopicDTO topic = topicService.getTopic(id);
		LOGGER.info("Topic DTO = {}", topic);

		return topic;
	}

	@PostMapping("/topic")
	public TopicDTO saveTopic(@RequestBody final TopicDTO topic) {

		final TopicDTO topicDTO = topicService.saveTopic(topic);
		LOGGER.info("Topic DTO = {}", topicDTO);

		return topicDTO;
	}

}
