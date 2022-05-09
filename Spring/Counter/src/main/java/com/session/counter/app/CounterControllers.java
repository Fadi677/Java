package com.session.counter.app;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterControllers {
	@RequestMapping("/")
	public String index(HttpSession session) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			int counter=(int) session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}
		return "index.jsp";
	}
	
	@RequestMapping("counter")
	public String viewCount(Model model,HttpSession session) {
		int sessionCounter=(int) session.getAttribute("count");
		sessionCounter++;
		model.addAttribute("counter",sessionCounter);
		return "counter.jsp";
}
	

	
	
}
