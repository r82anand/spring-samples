package com.sivadas.anand.dto;

import java.sql.Timestamp;

public class ChapterDTO {

	private Long id;
	private String title;
	private Timestamp createdDate;
	private Long createdBy;
	private ContentsDTO contents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public ContentsDTO getContents() {
		return contents;
	}

	public void setContents(ContentsDTO contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "ChapterDTO [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", contents=" + contents + "]";
	}

}
