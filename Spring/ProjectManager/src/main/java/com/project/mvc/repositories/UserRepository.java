package com.project.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.mvc.models.Project;
import com.project.mvc.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
		//get all users
		List<User> findAll();
		
		// Retrieves a list of all users for a particular project
		List<User> findAllByProjects(Project project);
		
		// Retrieves a list of any projects a particular user
	    // does not belong to.
	    List<User> findByProjectsNotContains(Project project);
	    
	    Optional<User> findByEmail(String email);
	
}
