package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.entity.Chapter;
import com.sivadas.anand.entity.repository.ChapterRepository;
import com.sivadas.anand.mapper.ChapterMapper;

@Service
public class ChapterService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ChapterService.class);
	
	@Autowired
	private ChapterRepository repository;
	
	@Autowired
	private ChapterMapper mapper;
	
	public List<ChapterDTO> getAllChapters() {
	
		List<Chapter> chapters = new ArrayList<>();
		Iterable<Chapter> results = repository.findAll();
		results.forEach(chapters :: add);
		chapters.forEach(element -> {
			LOGGER.info("Chapter = {}", element);
		});
		
		return mapper.contentsListToContenstDTOList(chapters);
	}

}
