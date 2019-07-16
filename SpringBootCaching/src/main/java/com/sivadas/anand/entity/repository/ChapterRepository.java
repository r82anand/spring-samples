package com.sivadas.anand.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.entity.Chapter;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {

}
