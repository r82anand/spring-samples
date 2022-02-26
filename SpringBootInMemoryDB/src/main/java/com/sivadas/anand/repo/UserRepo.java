package com.sivadas.anand.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
