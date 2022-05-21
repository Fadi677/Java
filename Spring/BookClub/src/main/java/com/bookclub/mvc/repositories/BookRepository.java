package com.bookclub.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.mvc.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	//retrieve all books
	List<Book> findAll();
	
	//
	
}
