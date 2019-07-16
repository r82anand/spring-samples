package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.entity.Contents;
import com.sivadas.anand.entity.repository.ContentsRepository;
import com.sivadas.anand.mapper.ContentsMapper;
import com.sivadas.anand.util.ApplicationConstants;

@Service
@CacheConfig(cacheNames = "contentsCache")
public class ContentsService {

	protected final static Logger LOGGER = LoggerFactory.getLogger(ContentsService.class);

	@Autowired
	private HazelcastInstance hazelcastInstance;
	@Autowired
	private ContentsRepository repository;

	@Autowired
	private ContentsMapper mapper;

	@Cacheable(value = "contentsCache")
	public List<ContentsDTO> getAllContents() {

		final List<Contents> contentsList = new ArrayList<>();
		final Iterable<Contents> results = repository.findAll();
		results.forEach(contentsList::add);
		contentsList.forEach(element -> {
			LOGGER.info("Contents = {}", element);
		});

		return mapper.contentsListToContenstDTOList(contentsList);
	}

	@Cacheable(value = "contentsCache", key = "#id")
	public ContentsDTO getContentById(final Long id) {

		ContentsDTO contentsDTO = new ContentsDTO();
		final Optional<Contents> result = repository.findById(id);
		if (result.isPresent()) {
			contentsDTO = mapper.contentsToContenstDTO(result.get());
			LOGGER.info("Loaded from DB");
		}

		return contentsDTO;
	}

	public ContentsDTO saveContent(final ContentsDTO content) {

		final Contents entity = mapper.contentsDTOToContents(content);
		final Contents contents = repository.save(entity);
		final ContentsDTO response = mapper.contentsToContenstDTO(contents);
		updateCache(response);

		return response;
	}

	private void updateCache(final ContentsDTO contentsDTO) {
		LOGGER.info("Loaded from DB to Cache");
		hazelcastInstance.getMap(ApplicationConstants.CONTENTS_CACHE).put(contentsDTO.getId(), contentsDTO);
	}

}
