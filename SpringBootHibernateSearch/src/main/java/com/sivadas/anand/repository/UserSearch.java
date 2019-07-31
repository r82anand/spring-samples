package com.sivadas.anand.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.enity.User;

/**
 * Search methods for the entity User using Hibernate search. The Transactional
 * annotation ensure that transactions will be opened and closed at the
 * beginning and at the end of each method.
 *
 */
@Repository
@Transactional
public class UserSearch {

	// Spring will inject here the entity manager object
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * A basic search for the entity User. The search is done by exact match per
	 * keywords on fields name, city and email.
	 *
	 * @param text The query text.
	 */
	public List<User> search(final String text) {

		// get the full text entity manager
		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		final QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(User.class).get();

		// a very basic query by keywords
		final Query query = queryBuilder.keyword().onFields("name", "city", "email").matching(text).createQuery();

		// wrap Lucene query in an Hibernate Query object
		final FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, User.class);

		// execute search and return results (sorted by relevance as default)
		@SuppressWarnings("unchecked")
		final List<User> results = jpaQuery.getResultList();

		return results;
	}

}
