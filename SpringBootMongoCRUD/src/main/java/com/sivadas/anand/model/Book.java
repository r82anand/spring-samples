package com.sivadas.anand.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = -4572838491829493105L;
	@Id
	private Long serialId;
	private String bookName;
	private String publishingCompany;

	public Book() {
		super();
	}

	public Book(final Long serialId, final String bookName, final String publishingCompany) {
		super();
		this.serialId = serialId;
		this.bookName = bookName;
		this.publishingCompany = publishingCompany;
	}

	public Long getSerialId() {
		return serialId;
	}

	public void setSerialId(final Long serialId) {
		this.serialId = serialId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(final String bookName) {
		this.bookName = bookName;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(final String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bookName == null ? 0 : bookName.hashCode());
		result = prime * result + (publishingCompany == null ? 0 : publishingCompany.hashCode());
		result = prime * result + (serialId == null ? 0 : serialId.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Book [serialId=" + serialId + ", bookName=" + bookName + ", publishingCompany=" + publishingCompany
				+ "]";
	}

}
