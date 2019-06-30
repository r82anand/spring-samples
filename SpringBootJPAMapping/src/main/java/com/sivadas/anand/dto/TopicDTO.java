package com.sivadas.anand.dto;

import java.sql.Timestamp;
import java.util.List;

public class TopicDTO {

	private Long id;
	private String title;
	private Timestamp createdDate;
	private Long createdBy;
	private List<ChapterDTO> chapters;

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

	public List<ChapterDTO> getChapters() {
		return chapters;
	}

	public void setChapters(List<ChapterDTO> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "TopicDTO [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", chapters=" + chapters + "]";
	}

}
