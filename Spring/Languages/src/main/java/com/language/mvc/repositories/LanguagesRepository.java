package com.language.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.language.mvc.models.Language;



@Repository
public interface LanguagesRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
}
