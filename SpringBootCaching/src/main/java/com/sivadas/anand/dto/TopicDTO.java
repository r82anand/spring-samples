package com.sivadas.anand.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class TopicDTO implements Serializable {

	private static final long serialVersionUID = -1052150838172456580L;
	private Long id;
	private String title;
	private String description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TopicDTO [id=" + id + ", title=" + title + ", description=" + description + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", chapters=" + chapters + "]";
	}
	
}
