package com.sivadas.anand.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long>{


}
