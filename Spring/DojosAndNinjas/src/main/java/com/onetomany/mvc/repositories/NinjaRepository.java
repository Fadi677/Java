package com.onetomany.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.mvc.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	//to get all ninjas
	List<Ninja> findAll();
	//get all ninjas for a dojo
	List<Ninja> findNinjasById(Long id);

}
