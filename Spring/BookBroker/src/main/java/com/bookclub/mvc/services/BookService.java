package com.bookclub.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.User;
import com.bookclub.mvc.repositories.BookRepository;


@Service
public class BookService {
	
	private BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo=bookRepo;
	}
	
		//get all books
		public List<Book> allBooks(){
			return bookRepo.findAll();
		}
		
		//create new book
		public Book createBook(Book book) {
			return bookRepo.save(book);
		}
		
		//get a book
		public Book findBook(Long id) {
			Optional<Book> optionalBook=bookRepo.findById(id);
			if (optionalBook.isPresent()) {
				return optionalBook.get();
			}
			else {
				return null;
			}
		}
		
		//update book
		public Book updateBook(Book book) {
			return bookRepo.save(book);
		}
		
		//delete book
		public void deleteBook(Long id) {
			Book requiredBook=findBook(id);
			bookRepo.delete(requiredBook);
		}
		
		//get all books borrowed by a certain user
		public List<Book> findBooksBorrowedBy(User user){
			List<Book> allBooksFor=bookRepo.findAllByBorrowedBy(user);
			return allBooksFor;
		}
}
