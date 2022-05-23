package com.project.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.mvc.models.Project;
import com.project.mvc.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	//get all projects
	List<Project> findAll();
	
	// Retrieves a list of all projects for a particular user
	List<Project> findAllByProjectUsers(User user);
	
	// Retrieves a list of any projects a particular user
    // does not belong to.
    List<Project> findByProjectUsersNotContains(User user);
	
}
