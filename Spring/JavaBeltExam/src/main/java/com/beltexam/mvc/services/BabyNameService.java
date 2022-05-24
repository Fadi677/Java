package com.beltexam.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.beltexam.mvc.models.BabyName;
import com.beltexam.mvc.repositories.BabyNameRepository;

@Service
public class BabyNameService {
	
	private BabyNameRepository babyNameRepo;
	
	public BabyNameService(BabyNameRepository babyNameRepo) {
		this.babyNameRepo=babyNameRepo;
	}
	
	//get all baby names
	public List<BabyName> findAllNames() {
		List<BabyName> allTheNames=babyNameRepo.findAll();
		return allTheNames;
	}
	
	//create a new baby name
	public BabyName createNewName(BabyName newBabyName) {
		return babyNameRepo.save(newBabyName);
		
	}
	
	
	//get a certain BabyName
	public BabyName findBabyName(Long id) {
		Optional<BabyName> optionalBabyName=babyNameRepo.findById(id);
				if(optionalBabyName.isPresent()) {
					return optionalBabyName.get();
				}
		else {
			return null;
		}
	}
	
	//update a BabyName
	public BabyName updateBabyName(BabyName newBabyName) {
		return babyNameRepo.save(newBabyName);
	}
	
	//delete a BabyName
	public void deleteBabyName(Long id) {
		BabyName babyNameToDelete=findBabyName(id);
		babyNameRepo.delete(babyNameToDelete);
	}
	
	
	
	
}
