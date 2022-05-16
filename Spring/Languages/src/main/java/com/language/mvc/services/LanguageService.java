package com.language.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.language.mvc.models.Language;
import com.language.mvc.repositories.LanguagesRepository;




@Service
public class LanguageService {
	private final LanguagesRepository languagesRepository;
	
	public LanguageService(LanguagesRepository languagesRepository) {
		this.languagesRepository=languagesRepository;
	}
	
		//get all languages
		public List<Language> allLanguages(){
			return languagesRepository.findAll();
		}
		
		//create new language
		public Language createLanguage(Language language) {
			return languagesRepository.save(language);
		}
	
		// retrieve a language
		 public Language findLanguage(Long id) {
		     Optional<Language> optionalLanguage = languagesRepository.findById(id);
		     if(optionalLanguage.isPresent()) {
		         return optionalLanguage.get();
		     } else {
		         return null;
		     }
		}
		 
		//update a language
		 public Language updateLanguage(Language language) {
			 return languagesRepository.save(language);
		 }
		 
		 //delete language
		 public void deleteLanguage(Long id) {
			 Language language=findLanguage(id);
			 languagesRepository.delete(language);
		 }
		
}
