package com.sivadas.anand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.entity.User;
import com.sivadas.anand.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

}
