package com.sivadas.anand.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

public class LuceneIndexServiceBean {

	private final FullTextEntityManager fullTextEntityManager;

	public LuceneIndexServiceBean(final EntityManagerFactory entityManagerFactory) {
		fullTextEntityManager = Search.getFullTextEntityManager(entityManagerFactory.createEntityManager());
	}

	public void triggerIndexing() {
		try {
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
