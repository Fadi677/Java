package com.fortune.omikuji.friend;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FortuneControllers {
	@RequestMapping("/omikuji")
	public String fortune() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/passData", method=RequestMethod.POST)
	public String processData(HttpSession session,
		@RequestParam(value="yearNumber") Integer Number,
		@RequestParam(value="city") String cityName,
		@RequestParam(value="personName") String personName,
		@RequestParam(value="hobby") String hobbyName,
		@RequestParam(value="livingThing") String livingName,
		@RequestParam(value="saySomething") String saying) {
		
		session.setAttribute("yearsCount", Number);
		session.setAttribute("nameOfCity", cityName);
		session.setAttribute("nameOfPerson", personName);
		session.setAttribute("nameOfHobby", hobbyName);
		session.setAttribute("nameOfLiving", livingName);
		session.setAttribute("sayingText", saying);
		
		return "redirect:/show";
		
	}
	
	@RequestMapping("/show")
	public String showFortune(Model model,HttpSession session) {
		model.addAttribute("yearNumber",session.getAttribute("yearsCount"));
		model.addAttribute("city",session.getAttribute("nameOfCity"));
		model.addAttribute("personName",session.getAttribute("nameOfPerson"));
		model.addAttribute("hobby",session.getAttribute("nameOfHobby"));
		model.addAttribute("livingThing",session.getAttribute("nameOfLiving"));
		model.addAttribute("saySomething",session.getAttribute("sayingText"));
		
		return "show.jsp";
	}
	
}
