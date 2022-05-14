package com.books.controllers;

import org.springframework.stereotype.Controller;

import com.books.services.BookService;
import com.books.models.Book;

@Controller
public class BooksController {
	 private final BookService bookServiceC;
	
	 public BooksController(BookService bookServiceC){
	        this.bookServiceC = bookServiceC;
	    }
	
	
	 
	 
}
