package com.sivadas.anand.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.sivadas.anand.dto.ContentsDTO;
import com.sivadas.anand.entity.Contents;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface ContentsMapper {
	
	ContentsDTO contentsToContenstDTO(Contents entity);

	List<ContentsDTO> contentsListToContenstDTOList (List<Contents> entityList);
}
