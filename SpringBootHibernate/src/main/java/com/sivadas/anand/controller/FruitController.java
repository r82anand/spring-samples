package com.sivadas.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.entity.Fruit;
import com.sivadas.anand.service.FruitService;

@RestController
public class FruitController {

	@Autowired
	private FruitService service;
	
	@RequestMapping(path = "/fruits", method = RequestMethod.GET, produces = "application/json")
	public List<Fruit> getAllFruits() {
		return service.getAllFruits();
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Fruit addFruit(@RequestBody Fruit fruit) {
		return service.addFruit(fruit);
	}
	
	
	@GetMapping("/fruit/{id}")
	public Fruit getFruitById(@PathVariable("id") Integer id) {
		return service.getFruitById(id);
	}
	
}
