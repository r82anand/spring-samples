package com.sivadas.anand.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.entity.Chapter;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.FIELD, uses = {ContentsMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface ChapterMapper {
	
//	ChapterMapper INSTANCE = Mappers.getMapper(ChapterMapper.class);

//	@Mappings({
//		@Mapping(target="id", source="entity.id")
//		})
	ChapterDTO chapterToChapterDTO(Chapter entity);

	List<ChapterDTO> contentsListToContenstDTOList (List<Chapter> entityList);

}
