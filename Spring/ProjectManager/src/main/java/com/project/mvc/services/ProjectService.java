package com.project.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.mvc.models.Project;
import com.project.mvc.models.User;
import com.project.mvc.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	private ProjectRepository projectRepo;
	
	
	public ProjectService(ProjectRepository projectRepo) {
		this.projectRepo=projectRepo;
	}


	public List<Project> findAllProjectsNot(User currentUser) {
		List<Project> projectsNotForUser=projectRepo.findByProjectUsersNotContains(currentUser);
		return projectsNotForUser;
	}


	public List<Project> findProjectsForUser(User currentUser) {
		List<Project> projectsForUser=projectRepo.findAllByProjectUsers(currentUser);
		return projectsForUser;
	}


	public Project createProject(Project newProject) {
		return projectRepo.save(newProject);
		
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject=projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}
		else{
			return null;
		}
	}


	public void deleteProject(Long id) {
		Project projectToDelete=findProject(id);
		projectRepo.delete(projectToDelete);
		
	}
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
}
