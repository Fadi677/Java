package com.human.demo.search;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanControllers {
		
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String username, @RequestParam(value="last_name",required=false) String last_name
			) {
		if(username==null) {
		return "Hello Human";
	}
		else if(last_name==null){
			return "Hello "+username;
		}
		
		else {
			return "Hello "+username+" "+last_name;
		}
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam(value="name", required=false) String username,@RequestParam(value="number", required=false) int number) {
		String statement="Hello "+username+" ";
		return statement.repeat(number);
	}
	
	
}