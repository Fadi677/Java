package com.onetomany.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onetomany.mvc.models.Dojo;
import com.onetomany.mvc.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	
	//get all dojos
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	//create new dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//get a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo=dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	//update dojo
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//delete dojo
	public void deleteDojo(Long id) {
		Dojo requiredDojo=findDojo(id);
		dojoRepository.delete(requiredDojo);
	}
	
}
