package com.sivadas.anand.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.serivce.ContentsService;

@Component
public class CacheScheduler {

	protected static final Logger LOGGER = LoggerFactory.getLogger(CacheScheduler.class);

	@Autowired
	private ContentsService contentService;

	@Autowired
	private HazelcastInstance hazelcastInstance;

	public HazelcastInstance getHazelcastInstance() {
		return hazelcastInstance;
	}

	public void setHazelcastInstance(final HazelcastInstance hazelcastInstance) {
		this.hazelcastInstance = hazelcastInstance;
	}

//	@Scheduled(fixedDelay = 60000)
	public void loadAllContents() {
		final List<ContentsDTO> allContents = contentService.getAllContents();
		for (final ContentsDTO contentsDTO : allContents) {
			hazelcastInstance.getMap("contentsCache").put(contentsDTO.getId(), contentsDTO);
			LOGGER.info("added to cache");
		}
	}

}
