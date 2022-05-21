package com.bookclub.mvc.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bookclub.mvc.models.LoginUser;
import com.bookclub.mvc.models.User;
import com.bookclub.mvc.repositories.UserRepository;
    

    
@Service
public class UserService {
    
	
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "The email entered for registration already exists");
    	}
    	String checkUserName=newUser.getUserName();
    	if(!checkUserName.matches("[a-zA-Z]+")) {
    		result.rejectValue("userName", "Matches", "UserName should only contain letters");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}

    	else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		userRepo.save(newUser);
    		return newUser;
    	}
    }
    
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	if(result.hasErrors()) {
    		return null;
    	}
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "The Email you entered isn't registered yet");
    	}
    	User registeredUser=potentialUser.get();
    	String hashed = BCrypt.hashpw(newLoginObject.getPassword(), BCrypt.gensalt());
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), registeredUser.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    return null;
    	}
    	
    	else {
    		return registeredUser;
    	}
    }


	public User findUserById(Long userId) {
		Optional<User> optionalUser= userRepo.findById(userId);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}

}