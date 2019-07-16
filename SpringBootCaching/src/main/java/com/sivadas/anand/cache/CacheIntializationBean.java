package com.sivadas.anand.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hazelcast.core.HazelcastInstance;
import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.dto.TopicDTO;
import com.sivadas.anand.serivce.ChapterService;
import com.sivadas.anand.serivce.ContentsService;
import com.sivadas.anand.serivce.TopicService;
import com.sivadas.anand.util.ApplicationConstants;

@Component
public class CacheIntializationBean {

	protected static final Logger LOGGER = LoggerFactory.getLogger(CacheIntializationBean.class);

	@Autowired
	private HazelcastInstance hazelcastInstance;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private ContentsService contentService;
	@Autowired
	private TopicService topicService;

	@EventListener
	public void afterContextIntialized(final ContextRefreshedEvent event) throws Exception {
		loadAddContents();
		loadAllChapters();
		loadAllTopics();
	}

	private void loadAddContents() {

		final List<ContentsDTO> allContents = contentService.getAllContents();
		for (final ContentsDTO contentsDTO : allContents) {
			hazelcastInstance.getMap(ApplicationConstants.CONTENTS_CACHE).put(contentsDTO.getId(), contentsDTO);
			LOGGER.info("added to contents to cache");
		}
	}

	private void loadAllChapters() {

		final List<ChapterDTO> allChapeters = chapterService.getAllChapters();
//		for (final ChapterDTO chapterDTO : allChapeters) {
//			hazelcastInstance.getMap(ApplicationConstants.CHAPTER_CACHE).put(chapterDTO.getId(), chapterDTO);
//			LOGGER.info("added to chapers to cache");
//		}
		if (!CollectionUtils.isEmpty(allChapeters)) {
			allChapeters.forEach(element -> {
				hazelcastInstance.getMap(ApplicationConstants.CHAPTER_CACHE).put(element.getId(), element);
				LOGGER.info("added to chapers to cache");
			});
		}
	}

	private void loadAllTopics() {

		final List<TopicDTO> allTopics = topicService.getAllTopics();
		if (!CollectionUtils.isEmpty(allTopics)) {
			allTopics.forEach(element -> {
				hazelcastInstance.getMap(ApplicationConstants.TOPIC_CACHE).put(element.getId(), element);
				LOGGER.info("added to topics to cache");
			});
		}
	}

}
