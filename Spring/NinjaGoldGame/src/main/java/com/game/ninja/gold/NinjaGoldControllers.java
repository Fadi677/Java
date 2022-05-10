package com.game.ninja.gold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldControllers {
	
	@RequestMapping("/")
	public String mainPage(HttpSession session) {
		if(session.getAttribute("goldSum")==null) {
			ArrayList<String> activitiesList=new ArrayList<String>();
			session.setAttribute("goldSum",0);
			session.setAttribute("activities", activitiesList);
		}
		else {
			return "index.jsp";
		}
		return "index.jsp";
	}
	
	
	@RequestMapping(value="/processMoney", method=RequestMethod.POST)
	public String calculateMoney(HttpSession session, @RequestParam(value="whichForm") String activity) {
		Random rNumber=new Random();
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		if("farm".equals(activity)) {
			int goldFromSession=(int) session.getAttribute("goldSum");
			int rNum=rNumber.nextInt(11)+10;
			int goldEarned=goldFromSession+rNum;
			session.setAttribute("goldSum", goldEarned);
			String thisActivity="Earned "+goldEarned+" gold from the farm! \n";
			activities.add(0,thisActivity);
			 
		 }
		
		else if("cave".equals(activity)) {
			int goldFromSession=(int) session.getAttribute("goldSum");
			int rNum=rNumber.nextInt(11)+10;
			int goldEarned=goldFromSession+rNum;
			session.setAttribute("goldSum", goldEarned);
			String thisActivity="Earned "+goldEarned+" gold from the cave! \n";
			activities.add(0,thisActivity);
			 
		 }
		
		else if("house".equals(activity)) {
			int goldFromSession=(int) session.getAttribute("goldSum");
			int rNum=rNumber.nextInt(11)+10;
			int goldEarned=goldFromSession+rNum;
			session.setAttribute("goldSum", goldEarned);
			String thisActivity="Earned "+goldEarned+" gold from the house! \n";
			activities.add(0,thisActivity);
			 
		 }
		
		else {
			int goldFromSession=(int) session.getAttribute("goldSum");
			int rNum=rNumber.nextInt(101)-50;
			int goldEarned=goldFromSession+rNum;
			session.setAttribute("goldSum", goldEarned);
			String thisActivity="Earned or took "+goldEarned+" gold from the quest! \n";
			activities.add(0,thisActivity);
		}
		
		return "redirect:/";
		
	}
	
}
