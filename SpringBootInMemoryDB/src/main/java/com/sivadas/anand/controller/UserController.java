package com.sivadas.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.entity.User;
import com.sivadas.anand.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

}
