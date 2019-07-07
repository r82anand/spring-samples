package com.sivadas.anand.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Chapter")
@Table(name = "CHAPTER")
@NamedQuery(name = "Chapter.findAllChapters",
query = "SELECT t FROM Chapter t")
public class Chapter implements Serializable {

	private static final long serialVersionUID = 6438779629485768640L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "CREATED_USER")
	private Long createdBy;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TOPIC_ID")
	@JsonIgnore
	private Topic topic;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
	private Contents contents;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="section_id")
	private Chapter section;
	
	@OneToMany(mappedBy="section")
	private Set<Chapter> sections = new HashSet<Chapter>();

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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public Contents getContents() {
		return contents;
	}

	public void setContents(Contents contents) {
		this.contents = contents;
	}

	public Chapter getSection() {
		return section;
	}

	public void setSection(Chapter section) {
		this.section = section;
	}

	public Set<Chapter> getSections() {
		return sections;
	}

	public void setSections(Set<Chapter> sections) {
		this.sections = sections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}

}
