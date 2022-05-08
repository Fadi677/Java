package com.human.demo.search;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanControllers {
		
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String username) {
		if(username==null) {
		return "Hello Human";
	}
		else {
			return "Hello "+username;
		}
}
}