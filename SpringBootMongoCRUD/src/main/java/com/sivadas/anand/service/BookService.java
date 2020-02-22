/*
 * File name		: BookService.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 22-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.model.Book;
import com.sivadas.anand.repository.BookRepository;

/**
 * The Class BookService.
 */
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	/**
	 * Gets the book.
	 *
	 * @param serialId the serial id
	 * @return the book
	 */
	public Book getBook(final long serialId) {

		Book book = new Book();
		final Optional<Book> result = bookRepo.findById(1000l);
		if(result.isPresent()) {
			book = result.get();
		}

		return book;
	}

	/**
	 * Save.
	 *
	 * @param book the book
	 * @return the book
	 */
	public Book save(final Book book) {

		return bookRepo.save(book);
	}

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	public List<Book> getAllBooks() {

		return bookRepo.findAll();
	}

	/**
	 * Delete book.
	 *
	 * @param serialId the serial id
	 */
	public void deleteBook(final long serialId) {
		bookRepo.deleteById(serialId);
	}

}
