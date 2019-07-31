package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		final List<Topic> topics = new ArrayList<>();
		final Iterable<Topic> results = repository.findAll();
		results.forEach(topics::add);
		topics.forEach(e -> LOGGER.info("Topic = {}", e));

		return mapper.topicListToTopicDTOList(topics);
	}

	public TopicDTO getTopic(final Long id) {

		TopicDTO dto = new TopicDTO();
		final Optional<Topic> findById = repository.findById(id);
		if (findById.isPresent()) {
			final Topic topic = findById.get();
			dto = mapper.topicToTopicDTO(topic);
		}

		return dto;
	}

	public TopicDTO saveTopic(final TopicDTO topicDTO) {

		final Topic topic = mapper.topicDTOToTopic(topicDTO);
		final Topic save = repository.save(topic);
		final TopicDTO result = mapper.topicToTopicDTO(save);

		return result;
	}

}
