package com.sivadas.anand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.model.Book;
import com.sivadas.anand.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public Book getBook(final long serialId) {

		Book book = new Book();
		final Optional<Book> result = bookRepo.findById(1000l);
		if(result.isPresent()) {
			book = result.get();
		}

		return book;
	}

	public Book save(final Book book) {

		final Book save = bookRepo.save(book);
		return save;
	}

	public List<Book> getAllBooks() {

		return bookRepo.findAll();
	}

	public void deleteBook(final long serialId) {
		bookRepo.deleteById(serialId);
	}

}
