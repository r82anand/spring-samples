package com.sivadas.anand.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ContentsDTO implements Serializable {

	private static final long serialVersionUID = -489638064313125931L;
	private Long id;
	private String content;
	private Timestamp createdDate;
	private Long createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "ContentsDTO [id=" + id + ", content="
				+ content + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}

}
