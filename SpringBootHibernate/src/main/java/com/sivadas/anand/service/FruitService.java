package com.sivadas.anand.service;

import java.util.List;

import com.sivadas.anand.entity.Fruit;

public interface FruitService {

	public List<Fruit> getAllFruits();
	public Fruit addFruit(Fruit fruit);
	public Fruit getFruitById(int id);
	
}
