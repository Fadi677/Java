package com.onetomany.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onetomany.mvc.models.Dojo;
import com.onetomany.mvc.models.Ninja;
import com.onetomany.mvc.repositories.NinjaRepository;



@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;
private final DojoService dojoService;

	public NinjaService(NinjaRepository ninjaRepository, DojoService dojoService) {
		this.ninjaRepository=ninjaRepository;
		this.dojoService=dojoService;
	}
	
	//get all ninja
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	//create new ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//get a ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja=ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
	//update ninja
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//delete ninja
	public void deleteDojo(Long id) {
		Ninja requiredNinja=findNinja(id);
		ninjaRepository.delete(requiredNinja);
	}
	
	//get all ninjas for a dojo
	
	
}
