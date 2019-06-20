package com.sivadas.anand.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sivadas.anand.entity.Fruit;

@Transactional
@Repository
public class FruitDAO {
	@PersistenceContext
	private EntityManager entityManager;	
	
	public Fruit getFruitById(int id) {
		return entityManager.find(Fruit.class, id);
	}
	
}
