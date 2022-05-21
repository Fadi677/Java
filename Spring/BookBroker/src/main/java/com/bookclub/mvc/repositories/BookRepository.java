package com.bookclub.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.User;


public interface BookRepository extends CrudRepository<Book, Long>{
	
	//retrieve all books
	List<Book> findAll();
	
	//List of all books borrowed by a user
	List<Book> findAllByBorrowedBy(User user);
	
}
