package com.language.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.language.mvc.models.Language;
import com.language.mvc.services.LanguageService;




@Controller
public class LanguagesControllers {
	private final LanguageService languageService;
	
	public LanguagesControllers(LanguageService languageService) {
		this.languageService=languageService;
	}
	
	//render index page
	@GetMapping("/languages")
	public String index(Model model,@ModelAttribute("languages")Language allLanguages) {
		List<Language> listOfLanguages=languageService.allLanguages();
		model.addAttribute("languagesList", listOfLanguages);
		return "index.jsp";
	}
	
	//add new language
	@PostMapping("/languages")
		public String createLanguage(@Valid @ModelAttribute("languages") Language newlanguage, BindingResult result) {
			if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	        	languageService.createLanguage(newlanguage);
	            return "redirect:/languages";
	        }
	}
	
	//show a specific language
	@GetMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language thisLanguage=languageService.findLanguage(id);
		model.addAttribute("showLanguage", thisLanguage);
		return "show.jsp";
	}
	
	//delete a specific language
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	//show edit page
	@GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {  
        Language language = languageService.findLanguage(id);
        model.addAttribute("thisLanguage", language);
        return "edit.jsp";
    }
	
	//update language
	@PutMapping("/languages/{id}")
    public String update( @Valid @ModelAttribute("languages") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/{id}/edit";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
	
}
