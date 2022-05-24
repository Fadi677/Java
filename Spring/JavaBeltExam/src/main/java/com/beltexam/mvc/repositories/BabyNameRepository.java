package com.beltexam.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beltexam.mvc.models.BabyName;

@Repository
public interface BabyNameRepository extends CrudRepository<BabyName, Long> {
	
	//get all baby names
	List<BabyName> findAll();
	
}
