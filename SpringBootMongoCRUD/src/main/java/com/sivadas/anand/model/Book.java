/*
 * File name		: Book.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 22-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Book.
 */
@Document(collection = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = -4572838491829493105L;
	@Id
	private Long serialId;
	private String bookName;
	private String publishingCompany;
	private Author author;

	/**
	 * Instantiates a new book.
	 */
	public Book() {
		super();
	}

	/**
	 * Instantiates a new book.
	 *
	 * @param serialId the serial id
	 * @param bookName the book name
	 * @param publishingCompany the publishing company
	 * @param author the author
	 */
	public Book(final Long serialId, final String bookName, final String publishingCompany, final Author author) {
		super();
		this.serialId = serialId;
		this.bookName = bookName;
		this.publishingCompany = publishingCompany;
		this.author = author;
	}

	/**
	 * Gets the serial id.
	 *
	 * @return the serial id
	 */
	public Long getSerialId() {
		return serialId;
	}

	/**
	 * Sets the serial id.
	 *
	 * @param serialId the new serial id
	 */
	public void setSerialId(final Long serialId) {
		this.serialId = serialId;
	}

	/**
	 * Gets the book name.
	 *
	 * @return the book name
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * Sets the book name.
	 *
	 * @param bookName the new book name
	 */
	public void setBookName(final String bookName) {
		this.bookName = bookName;
	}

	/**
	 * Gets the publishing company.
	 *
	 * @return the publishing company
	 */
	public String getPublishingCompany() {
		return publishingCompany;
	}

	/**
	 * Sets the publishing company.
	 *
	 * @param publishingCompany the new publishing company
	 */
	public void setPublishingCompany(final String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(final Author author) {
		this.author = author;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bookName == null ? 0 : bookName.hashCode());
		result = prime * result + (publishingCompany == null ? 0 : publishingCompany.hashCode());
		result = prime * result + (serialId == null ? 0 : serialId.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Book other = (Book) obj;
		if (bookName == null) {
			if (other.bookName != null) {
				return false;
			}
		} else if (!bookName.equals(other.bookName)) {
			return false;
		}
		if (publishingCompany == null) {
			if (other.publishingCompany != null) {
				return false;
			}
		} else if (!publishingCompany.equals(other.publishingCompany)) {
			return false;
		}
		if (serialId == null) {
			if (other.serialId != null) {
				return false;
			}
		} else if (!serialId.equals(other.serialId)) {
			return false;
		}
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Book [serialId=" + serialId + ", bookName=" + bookName + ", publishingCompany=" + publishingCompany
				+ "]";
	}

}
