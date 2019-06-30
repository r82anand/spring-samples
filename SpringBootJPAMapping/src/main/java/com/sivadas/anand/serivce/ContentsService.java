package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.entity.Contents;
import com.sivadas.anand.entity.repository.ContentsRepository;

@Service
public class ContentsService {
	
	protected final static Logger LOGGER = LoggerFactory.getLogger(ContentsService.class);

	@Autowired
	private ContentsRepository repository;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	public List<ContentsDTO> getAllContents() {
		
		List<Contents> contentsList = new ArrayList<>();
		Iterable<Contents> results = repository.findAll();
		results.forEach(contentsList :: add);
		contentsList.forEach(element -> {
			LOGGER.info("Contents = {}", element);
		});
		
		return transformContensts(contentsList);
	}

	private List<ContentsDTO> transformContensts(List<Contents> contentsList) {

		List<ContentsDTO> allContents = new ArrayList<>();
		contentsList.forEach(element -> {
			ContentsDTO contentsDTO = new ContentsDTO();
			mapper.map(element, contentsDTO);
			allContents.add(contentsDTO);
		});
		
		return allContents;
	}
	
}
