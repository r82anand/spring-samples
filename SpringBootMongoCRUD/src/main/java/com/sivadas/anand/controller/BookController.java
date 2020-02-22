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

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(path = "/saveBook")
	public void saveBook(@RequestBody(required = true) final Book book) {
		bookService.save(book);
	}

	@GetMapping(path = "/book")
	public Book getBook(@RequestParam(name = "id",required = true, defaultValue = "1000l") final long serialId) {
		return bookService.getBook(serialId);
	}

	@GetMapping(path = "/books")
	public List<Book> getBook() {
		return bookService.getAllBooks();
	}

	@DeleteMapping(path = "/book")
	public void deleteBook(@RequestParam(name = "id",required = true, defaultValue = "1000l") final long serialId) {
	 bookService.deleteBook(serialId);
	}

}
