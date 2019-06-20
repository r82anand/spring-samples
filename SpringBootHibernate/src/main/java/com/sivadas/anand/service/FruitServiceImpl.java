package com.sivadas.anand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dao.FruitDAO;
import com.sivadas.anand.entity.Fruit;
import com.sivadas.anand.repo.FruitRepo;

@Service
public class FruitServiceImpl implements FruitService {
	
	@Autowired
	FruitRepo repo;
	
	@Autowired
	FruitDAO dao;

	@Override
	public List<Fruit> getAllFruits() {
		return (List<Fruit>) repo.findAll();
	}

	@Override
	public Fruit addFruit(Fruit fruit) {
		
		return repo.save(fruit);
	}

	@Override
	public Fruit getFruitById(int id) {
		return dao.getFruitById(id);
	}
	
}
