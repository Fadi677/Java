package com.onetomany.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onetomany.mvc.models.Dojo;
import com.onetomany.mvc.models.Ninja;
import com.onetomany.mvc.services.DojoService;
import com.onetomany.mvc.services.NinjaService;

@Controller
public class DojosNinjasController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosNinjasController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService=dojoService;
		this.ninjaService=ninjaService;
	}
	
	@GetMapping("/")
	public String showMain() {
		return "index.jsp";
	}
	
	@GetMapping("/dojos")
	public String showAllDojos(Model model) {
		List<Dojo> allDojos=dojoService.allDojos();
		model.addAttribute("allTheDojos", allDojos);
		return "dojos.jsp";
	}
	
	@GetMapping("/ninjas")
	public String showAllNinjas(Model model) {
		List<Ninja> allNinjas=ninjaService.allNinjas();
		model.addAttribute("allTheNinjas", allNinjas);
		return "ninjas.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String createDojo(@ModelAttribute("createNewDojo") Dojo newDojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("createNewDojo") Dojo newDojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newdojo.jsp";
		}
		else {
			///////////
			dojoService.createDojo(newDojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo=dojoService.findDojo(id);
		model.addAttribute("thisDojo", dojo);
		return "showdojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("createNewNinja") Ninja newNinja, Model model) {
		List<Dojo> allDojos=dojoService.allDojos();
		model.addAttribute("dojosList",allDojos );
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("createNewNinja") Ninja newNinja, BindingResult result) {
		if (result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			Ninja addedNinja=ninjaService.createNinja(newNinja);
			Long newNinjaId=addedNinja.getId();
			return "redirect:/ninjas/"+newNinjaId;
		}
	}
	
	@GetMapping("/ninjas/{id}")
	public String showNinja( @PathVariable("id") Long id, Model model) {
		Ninja ninja=ninjaService.findNinja(id);
		model.addAttribute("thisNinja", ninja);
		return "showninja.jsp";
	}
	
}
