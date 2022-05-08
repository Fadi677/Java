package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/Daikichi")
public class Daikichi {

	@RequestMapping("")
    public String hello() {
            return "Welcome!";
}
	
	@RequestMapping("/today")
    public String today() {
            return "Today you will find luck in all your endaovers!";
	
}
	
	@RequestMapping("/tomorrow")
    public String tomorrow() {
            return "Tomorrow,an idea will rise, so be sure to be open to new ideas!";
	
}
	@RequestMapping("/travel/{city}")
		public String travel(@PathVariable("city") String city) {
			return "Congratulations! You will soon travel to "+ city;
			
		}

	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if(number %2==1) {
			return  "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		else {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		
	}
	
	
}