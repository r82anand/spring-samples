package com.sivadas.anand.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.sivadas.anand.dto.TopicDTO;
import com.sivadas.anand.entity.Topic;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.FIELD, uses = {ChapterMapper.class, ContentsMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface TopicMapper {

	TopicDTO topicToTopicDTO(Topic entity);

	List<TopicDTO> topicListToTopicDTOList (List<Topic> entityList);
}
