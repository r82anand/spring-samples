package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.entity.Contents;
import com.sivadas.anand.entity.repository.ContentsRepository;
import com.sivadas.anand.mapper.ContentsMapper;

@Service
public class ContentsService {

	protected final static Logger LOGGER = LoggerFactory.getLogger(ContentsService.class);

	@Autowired
	private ContentsRepository repository;

	@Autowired
	private ContentsMapper mapper;

	@Cacheable(value = "contentsCache")
	public List<ContentsDTO> getAllContents() {

		List<Contents> contentsList = new ArrayList<>();
		Iterable<Contents> results = repository.findAll();
		results.forEach(contentsList::add);
		contentsList.forEach(element -> {
			LOGGER.info("Contents = {}", element);
		});

		return mapper.contentsListToContenstDTOList(contentsList);
	}

	@Cacheable(value = "contentsCache", key = "#id")
	public ContentsDTO getContentById(Long id) {

		ContentsDTO contentsDTO = new ContentsDTO();
		Optional<Contents> result = repository.findById(id);
		if (result.isPresent()) {
			contentsDTO = mapper.contentsToContenstDTO(result.get());
		}

		return contentsDTO;
	}

	@Cacheable(value = "contentsCache")
	public ContentsDTO saveContent(ContentsDTO content) {

		Contents entity = mapper.contentsDTOToContents(content);
		Contents contents = repository.save(entity);
		
		return mapper.contentsToContenstDTO(contents);
	}

}
