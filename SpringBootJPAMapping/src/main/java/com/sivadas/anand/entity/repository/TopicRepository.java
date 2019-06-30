package com.sivadas.anand.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.entity.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

}
