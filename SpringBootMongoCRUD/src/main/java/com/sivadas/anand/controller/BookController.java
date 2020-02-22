/*
 * File name		: BookController.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 22-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.model.Book;
import com.sivadas.anand.service.BookService;

/**
 * The Class BookController.
 */
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Save book.
	 *
	 * @param book the book
	 */
	@PostMapping(path = "/saveBook")
	public void saveBook(@RequestBody(required = true) final Book book) {
		bookService.save(book);
	}

	/**
	 * Gets the book.
	 *
	 * @param serialId the serial id
	 * @return the book
	 */
	@GetMapping(path = "/book")
	public Book getBook(@RequestParam(name = "id",required = true, defaultValue = "1000l") final long serialId) {
		return bookService.getBook(serialId);
	}

	/**
	 * Gets the book.
	 *
	 * @return the book
	 */
	@GetMapping(path = "/books")
	public List<Book> getBook() {
		return bookService.getAllBooks();
	}

	/**
	 * Delete book.
	 *
	 * @param serialId the serial id
	 */
	@DeleteMapping(path = "/book")
	public void deleteBook(@RequestParam(name = "id",required = true, defaultValue = "1000l") final long serialId) {
	 bookService.deleteBook(serialId);
	}

}
