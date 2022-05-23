package com.project.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.project.mvc.models.LoginUser;
import com.project.mvc.models.Project;
import com.project.mvc.models.User;
import com.project.mvc.services.ProjectService;
import com.project.mvc.services.UserService;

@Controller
public class ProjectControllers {
	private UserService userServ;
	private ProjectService projectServ;
	
	public ProjectControllers(UserService userServ, ProjectService projectServ) {
		this.userServ=userServ;
		this.projectServ=projectServ;
	}
	
	 @GetMapping("/")
	    public String index(Model model, HttpSession session) {
	    	
	    	if (session.getAttribute("userId")!=null) {
	    		return "redirect:/dashboard";
	    	}
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        // TO-DO Later -- call a register method in the service 
	        // to do some extra validations and create a new user!
	    	User registeredUser=userServ.register(newUser, result);
	    	
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("userId", registeredUser.getId());
	        return "redirect:/dashboard";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	         User user = userServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("userId", user.getId());
	    
	        return "redirect:/dashboard";
	    }
	    
	    
	    @GetMapping("/dashboard")
	    public String showBookMarket(Model model, HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	    		Long userId= (Long) session.getAttribute("userId");
	    		model.addAttribute("currentUserId", userId);
	    		User currentUser=userServ.findUserById(userId);
	    		model.addAttribute("currentUser", currentUser);
	    		List<Project> allProjectsNot=projectServ.findAllProjectsNot(currentUser);
	    		System.out.println("---------"+allProjectsNot);
	    		model.addAttribute("projectsNot", allProjectsNot);
	    		List<Project> allProjectsFor=projectServ.findProjectsForUser(currentUser);
	    		System.out.println("+++++++++"+allProjectsFor);
	    		model.addAttribute("projectsFor", allProjectsFor);
	    		return "home.jsp";
	    	}
	    		return "redirect:/";
	    }
	    
	    @GetMapping("/logout")
	    public String logOut(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
	    
	    
	    @GetMapping("/projects/new")
	    public String createProject(@ModelAttribute("newProject") Project newProject, HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	    		Long userId= (Long) session.getAttribute("userId");
	    		User currentUser=userServ.findUserById(userId);
	    		return "newProject.jsp";
	    	}
	    	return "redirect:/";
	    }
	    
	    @PostMapping("/projects/new")
	    public String addNewProject(@Valid @ModelAttribute("newProject") Project newProject, BindingResult result, HttpSession session){
	    	if (result.hasErrors()) {
	    		return "newProject.jsp";
	    	}
	    	Long userId= (Long) session.getAttribute("userId");
    		User currentUser=userServ.findUserById(userId);
    		newProject.setProjectLeader(currentUser);
    		newProject.addUserToProject(currentUser);
    		projectServ.createProject(newProject);
    		return "redirect:/dashboard";
	    }
	
	    @GetMapping("/projects/{id}")
	    public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	        	Long userId= (Long) session.getAttribute("userId");
	        	model.addAttribute("currentUserId", userId);
	        	Project thisProject=projectServ.findProject(id);
	        	model.addAttribute("projectDet", thisProject);
	        	System.out.println("sssssssssss"+thisProject);
	        	return "showProject.jsp";
	    	}
	    	return "redirect:/";
	    }
	
	    @DeleteMapping("/projects/{id}/delete")
	    public String deleteProject(@PathVariable("id") Long id,  HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	    		Long userId= (Long) session.getAttribute("userId");
	    		projectServ.deleteProject(id);
	    		return "redirect:/dashboard";
	    	}
	    	return "redirect:/";
	    }
	    
	    @GetMapping("projects/{id}/join")
	    public String joinProject(@PathVariable("id") Long id,  HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	    		Long userId= (Long) session.getAttribute("userId");
	    		User userToAdd=userServ.findUserById(userId);
	    		Project thisProject=projectServ.findProject(id);
	    		thisProject.addUserToProject(userToAdd);
	    		projectServ.updateProject(thisProject);
	    		return "redirect:/dashboard";
	    	}
	    	return "redirect:/";
	    }
	    
	    @GetMapping("projects/{id}/leave")
	    public String leaveProject(@PathVariable("id") Long id,  HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	    		Long userId= (Long) session.getAttribute("userId");
	    		User userToRemove=userServ.findUserById(userId);
	    		Project thisProject=projectServ.findProject(id);
	    		List<User> projectMembers=thisProject.getProjectUsers();
	    		projectMembers.remove(userToRemove);
	    		projectServ.updateProject(thisProject);
	    		return "redirect:/dashboard";
	    	}
	    	return "redirect:/";
	    }
	    
	    @GetMapping("projects/{id}/edit")
	    public String editProjectPage(@PathVariable("id") Long id, @ModelAttribute("newProject") Project newProject,Model model, HttpSession session) {
	    	if (session.getAttribute("userId")!=null) {
	    		Long userId= (Long) session.getAttribute("userId");
	    		Project projectToEdit=projectServ.findProject(id);
	    		model.addAttribute("thisProject",projectToEdit);
	    		return "editProject.jsp";
	    	}
	    	return "redirect:/";
	    }
	    
	    @PutMapping("projects/{id}/edit")
	    public String updateProject(@PathVariable("id") Long id,@Valid @ModelAttribute("newProject") Project newProject, BindingResult result,  HttpSession session) {
	    	if(result.hasErrors()) {
	    		return "projects/{id}/edit";
	    	}
	    	else {
	    		Long userId= (Long) session.getAttribute("userId");
	    		User updatedBy=userServ.findUserById(userId);
	    		newProject.setProjectLeader(updatedBy);
	    		newProject.addUserToProject(updatedBy);
	    		projectServ.updateProject(newProject);
	    		return "redirect:/dashboard";
	    	}
	    }
	
}
