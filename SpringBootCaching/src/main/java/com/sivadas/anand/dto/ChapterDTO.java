package com.sivadas.anand.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ChapterDTO implements Serializable {

	private static final long serialVersionUID = -3249399197064490080L;
	private Long id;
	private String title;
	private Timestamp createdDate;
	private Long createdBy;
	private ContentsDTO contents;
	private Set<ChapterDTO> sections = new HashSet<ChapterDTO>();

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
	
	public Set<ChapterDTO> getSections() {
		return sections;
	}

	public void setSections(Set<ChapterDTO> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "ChapterDTO [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", contents=" + contents + "]";
	}

}
