package com.sivadas.anand.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LuceneIndexConfig {

	@Bean
	public LuceneIndexServiceBean luceneIndexServiceBean(final EntityManagerFactory EntityManagerFactory) {
		final LuceneIndexServiceBean luceneIndexServiceBean = new LuceneIndexServiceBean(EntityManagerFactory);
		luceneIndexServiceBean.triggerIndexing();
		return luceneIndexServiceBean;
	}

}
