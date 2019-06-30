package com.sivadas.anand.entity;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Contents")
@Table(name = "CONTENTS")
public class Contents implements Serializable {

	private static final long serialVersionUID = -4727218515136333307L;
	@Id
    @GeneratedValue
	private Long id;
	@Column(name = "ARTICLE_TYPE")
	private String articleType;
	@Column(name = "ARTICLE_ID")
	private Long articleId;
	@Column(name = "TEXT")
	private Clob content;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "CREATED_USER")
	private Long createdBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public Clob getContent() {
		return content;
	}
	public void setContent(Clob content) {
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
		return "Contents [id=" + id + ", articleType=" + articleType + ", articleId=" + articleId + ", content="
				+ content + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}
}
