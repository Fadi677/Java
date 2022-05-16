package com.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.services.BookService;
import com.books.models.Book;

@Controller
public class BooksController {
	 private final BookService bookServiceC;
	
	 public BooksController(BookService bookServiceC){
	        this.bookServiceC = bookServiceC;
	    }
	 
//	 	@RequestMapping("/books")
//	 	public String index(Model model) {
//	    List<Book> listOfBooks=bookServiceC.allBooks();
//	    model.addAttribute("allBooks", listOfBooks);
//	    return "showAll.jsp";
//	    }
	    
	    @RequestMapping(value="/books/create", method=RequestMethod.POST)
	    public String create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        Book book = new Book(title, desc, lang, numOfPages);
	        bookServiceC.createBook(book);
	        return "redirect:/books";
	    }
	    
	    @RequestMapping("/books/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	        Book thisBook = bookServiceC.findBook(id);
	        model.addAttribute("book",thisBook);
	        return "show.jsp";
	    }
	    
	    @GetMapping(value="/books/new")
	    public String newBook() {
	    	 return "/books/newBook.jsp";
	    }
	    
	    @PostMapping("/books")
	    public String createNew(
	        @RequestParam("title") String title,
	        @RequestParam("description") String description,
	        @RequestParam("language") String language,
	        @RequestParam("pages") Integer pages) 
	    {
	        // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	        Book book = new Book(title, description, language, pages);
	        bookServiceC.createBook(book);
	        return "redirect:/dashboard";
	    }

	    
//	    @RequestMapping(value="/books/{id}/update", method=RequestMethod.PUT)
//	    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages){
//	    	Book book=bookServiceC.update(id, title, desc, lang,numOfPages);
//	    	return book;
//	    }
//	    
//	    @RequestMapping("/books/{id}/delete")
//	    public void deleteBook(@PathVariable("id") Long id) {
//	    	bookServiceC.deleteThisBook(id);
//	 
//	    }
	 
	 
}
