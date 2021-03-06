package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.TopicDTO;
import com.sivadas.anand.entity.Topic;
import com.sivadas.anand.entity.repository.TopicRepository;
import com.sivadas.anand.mapper.TopicMapper;

@Service
public class TopicService {

	protected final static Logger LOGGER = LoggerFactory.getLogger(TopicService.class);

	@Autowired
	private TopicRepository repository;

	@Autowired
	private TopicMapper mapper;

	public List<TopicDTO> getAllTopics() {

		List<Topic> topics = new ArrayList<>();
		Iterable<Topic> results = repository.findAll();
		results.forEach(topics::add);
		topics.forEach(e -> LOGGER.info("Topic = {}", e));

		return mapper.topicListToTopicDTOList(topics);
	}

}
