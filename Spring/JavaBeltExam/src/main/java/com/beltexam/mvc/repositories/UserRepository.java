package com.beltexam.mvc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beltexam.mvc.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	//get a user from dataBase by the user's email
	Optional<User> findByEmail(String email);
	
}
