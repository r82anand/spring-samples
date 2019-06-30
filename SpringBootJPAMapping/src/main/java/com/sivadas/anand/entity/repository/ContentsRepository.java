package com.sivadas.anand.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.entity.Contents;

@Repository
public interface ContentsRepository extends CrudRepository<Contents, Long> {

}
