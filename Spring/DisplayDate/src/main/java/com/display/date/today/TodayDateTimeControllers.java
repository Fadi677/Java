package com.display.date.today;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodayDateTimeControllers {
	
	@RequestMapping("/")
	public String dateTime() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String todayDate(Model model) {
		Date today = new Date();
		SimpleDateFormat day = new SimpleDateFormat("EEEE,");
		SimpleDateFormat dayNumber = new SimpleDateFormat(" d ");
		SimpleDateFormat month = new SimpleDateFormat("MMM, ");
		SimpleDateFormat year = new SimpleDateFormat("yyyy ");
		String dayResult = day.format(today);
		String dayNumberResult = dayNumber.format(today);
		String monthResult = month.format(today);
		String yearResult = year.format(today);
		
		model.addAttribute("todayDay",dayResult);
		model.addAttribute("todayDayNumber",dayNumberResult);
		model.addAttribute("todayMonth",monthResult);
		model.addAttribute("todayYear",yearResult);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String todayTime(Model model) {
		Date date = new Date();
	      String strDateFormat = "hh:mm a";
	      SimpleDateFormat time = new SimpleDateFormat(strDateFormat);
	      String thisTime=time.format(date);
	      model.addAttribute("nowTime",thisTime);
	      return "time.jsp";
	}
}
