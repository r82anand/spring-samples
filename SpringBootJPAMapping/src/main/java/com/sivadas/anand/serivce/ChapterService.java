package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.entity.Chapter;
import com.sivadas.anand.entity.Contents;
import com.sivadas.anand.entity.repository.ChapterRepository;

@Service
public class ChapterService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ChapterService.class);
	
	@Autowired
	private ChapterRepository repository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	public List<ChapterDTO> getAllChapeters() {
	
		List<Chapter> chapters = new ArrayList<>();
		Iterable<Chapter> results = repository.findAll();
		results.forEach(chapters :: add);
		chapters.forEach(element -> {
			LOGGER.info("Chapter = {}", element);
		});
		
		return transformChapters(chapters);
	}

	private List<ChapterDTO> transformChapters(List<Chapter> chapters) {
		
		List<ChapterDTO> chapterList = new ArrayList<>();
		chapters.forEach(element -> {
			ChapterDTO chapterDTO = new ChapterDTO();
			mapper.map(element, chapterDTO);
			ContentsDTO contentsDTO = new ContentsDTO();
			Contents contents = element.getContents();
			mapper.map(contents, contentsDTO);
			chapterDTO.setContents(contentsDTO);
			chapterList.add(chapterDTO);
		});
		
		return chapterList;
	}	
	
}
