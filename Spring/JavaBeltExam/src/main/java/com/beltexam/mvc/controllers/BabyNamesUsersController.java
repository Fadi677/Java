package com.beltexam.mvc.controllers;

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

import com.beltexam.mvc.models.BabyName;
import com.beltexam.mvc.models.LoginUser;
import com.beltexam.mvc.models.User;
import com.beltexam.mvc.services.BabyNameService;
import com.beltexam.mvc.services.UserService;


@Controller
public class BabyNamesUsersController {
	
	private UserService userServ;
	private BabyNameService babyNameServ;
	
	
	public BabyNamesUsersController(UserService userServ, BabyNameService babyNameServ) {
		this.userServ=userServ;
		this.babyNameServ=babyNameServ;
	}
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
    	
    	if (session.getAttribute("userId")!=null) {
    		return "redirect:/home";
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
        return "redirect:/home";
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
    
        return "redirect:/home";
    }
	
	
	@GetMapping("/home")
	public String showHomePage(Model model, HttpSession session) {
		if (session.getAttribute("userId")!=null) {
			Long userId= (Long) session.getAttribute("userId");
    		model.addAttribute("currentUserId", userId);
    		User currentUser=userServ.findUserById(userId);
    		model.addAttribute("currentUser", currentUser);
    		List<BabyName> allBabyNames=babyNameServ.findAllNames();
    		model.addAttribute("listOfName", allBabyNames);
    		
    		
    		return "home.jsp";
		}
		return "redirect:/";
	}
		
	@GetMapping("/logout")
    public String logOut(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
	@GetMapping("/names/new")
	public String createNewName(@ModelAttribute("newName") BabyName newBabyName, HttpSession session) {
		if (session.getAttribute("userId")!=null) {
			Long userId= (Long) session.getAttribute("userId");
    		User currentUser=userServ.findUserById(userId);
    		return "newBabyName.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/names/new")
	public String addNewName(@Valid @ModelAttribute("newName") BabyName newBabyName, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "newBabyName.jsp";
		}
		Long userId= (Long) session.getAttribute("userId");
		User currentUser=userServ.findUserById(userId);
		newBabyName.setNamedBy(currentUser);
		babyNameServ.createNewName(newBabyName);
		return "redirect:/home";
	}
	
	//show a babyName details page
	@GetMapping("/names/{id}")
	public String showBabyName(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId")!=null) {
			Long userId= (Long) session.getAttribute("userId");
        	model.addAttribute("currentUserId", userId);
        	BabyName thisBaby=babyNameServ.findBabyName(id);
        	model.addAttribute("babyNameToShow", thisBaby);
        	return "showBabyName.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/names/{id}/edit")
	public String showEditPage(@PathVariable("id") Long id, @ModelAttribute("newName") BabyName newBabyName,Model model, HttpSession session) {
		if (session.getAttribute("userId")!=null) {
			Long userId= (Long) session.getAttribute("userId");
			model.addAttribute("currentUserId", userId);
			BabyName babyNameToEdit=babyNameServ.findBabyName(id);
			model.addAttribute("thisBabyName", babyNameToEdit);
			return "editBabyName.jsp";
		}
		return "redirect:/";
	}
	
	@PutMapping("/names/{id}/edit")
	public String updateBabyName(@PathVariable("id") Long id,@Valid @ModelAttribute("thisBabyName") BabyName newBabyName, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "names/{id}/edit";
		}
		else {
			Long userId= (Long) session.getAttribute("userId");
			User updatedBy=userServ.findUserById(userId);
			newBabyName.setNamedBy(updatedBy);
			babyNameServ.updateBabyName(newBabyName);
			return "redirect:/home";
		}
	}
	
	@DeleteMapping("/names/{id}/delete")
	public String deleteBabyName(@PathVariable("id") Long id,  HttpSession session) {
		if (session.getAttribute("userId")!=null) {
			Long userId= (Long) session.getAttribute("userId");
			babyNameServ.deleteBabyName(id);
			return "redirect:/home";
		}
		return "redirect:/";
	}
	
	
}
