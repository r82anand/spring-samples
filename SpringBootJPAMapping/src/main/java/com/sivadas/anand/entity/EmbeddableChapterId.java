package com.sivadas.anand.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddableChapterId implements Serializable {

	private static final long serialVersionUID = 5311175578338317384L;

	@Column(name = "ARTICLE_TYPE")
	private String articleType;
	@Column(name = "ARTICLE_ID")
	private Long articleId;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((articleType == null) ? 0 : articleType.hashCode());
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
		EmbeddableChapterId other = (EmbeddableChapterId) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (articleType == null) {
			if (other.articleType != null)
				return false;
		} else if (!articleType.equals(other.articleType))
			return false;
		return true;
	}
	
	
	
}
