package com.example.demo.controllers;

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
}