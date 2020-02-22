/*
 * File name		: BookRepository.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 22-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.model.Book;

/**
 * The Interface BookRepository.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, Long>{


}
