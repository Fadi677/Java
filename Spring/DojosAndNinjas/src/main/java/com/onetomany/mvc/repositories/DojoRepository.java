package com.onetomany.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.mvc.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	//to get all dojos
	List<Dojo> findAll();
}
