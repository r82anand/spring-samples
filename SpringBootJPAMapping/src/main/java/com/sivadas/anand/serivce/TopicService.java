package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.TopicDTO;
import com.sivadas.anand.entity.Topic;
import com.sivadas.anand.entity.repository.TopicRepository;

@Service
public class TopicService {
	
	protected final static Logger LOGGER = LoggerFactory.getLogger(TopicService.class);

	@Autowired
	private TopicRepository repository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	public List<TopicDTO> getAllTopics() {
		
		List<Topic> topics = new ArrayList<>();
		Iterable<Topic> results = repository.findAll();
		results.forEach(topics :: add);
		topics.forEach(e -> LOGGER.info("Topic = {}", e));
		
		return transformTopic(topics);
	}

	private List<TopicDTO> transformTopic(List<Topic> topics) {
		
		List<TopicDTO> topicList = new ArrayList<>();
		topics.forEach(topic -> {
			TopicDTO topicDTO = new TopicDTO();
			dozerBeanMapper.map(topic, topicDTO);
			topicList.add(topicDTO);
		});
		
		return topicList;
	}
	
}
