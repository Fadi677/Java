package com.bookclub.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookclub.mvc.models.Book;
import com.bookclub.mvc.models.LoginUser;
import com.bookclub.mvc.models.User;
import com.bookclub.mvc.services.BookService;
import com.bookclub.mvc.services.UserService;


@Controller
public class HomeController {
    
     private UserService userServ;
     private BookService bookServ;
     
     public HomeController(UserService userServ, BookService bookServ) {
    	 this.userServ=userServ;
    	 this.bookServ=bookServ;
     }
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	
    	if (session.getAttribute("userId")!=null) {
    		return "redirect:/bookmarket";
    	}
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	User registeredUser=userServ.register(newUser, result);
    	
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", registeredUser.getId());
        return "redirect:/bookmarket";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
    
        return "redirect:/bookmarket";
    }
    
//    @GetMapping("/books")
//    public String showHome(Model model, HttpSession session) {
//    	if (session.getAttribute("userId")!=null) {
//    		Long userId= (Long) session.getAttribute("userId");
//    		User currentUser=userServ.findUserById(userId);
//    		model.addAttribute("currentUser", currentUser);
//    		List<Book> allBooks=bookServ.allBooks();
//    		model.addAttribute("allTheBooks", allBooks);
//    		System.out.println("Im in the Controller!!!"+allBooks);
//    		return "home.jsp";
//    	}
//    		return "redirect:/";
//    }
    
    @GetMapping("/bookmarket")
    public String showBookMarket(Model model, HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		model.addAttribute("currentUserId", userId);
    		User currentUser=userServ.findUserById(userId);
    		model.addAttribute("currentUser", currentUser);
//    		Book theBook = bookServ.findBook(id);
//    		Long postedById=theBook.getPostedBy().getId();
//    		model.addAttribute("postedById", postedById);
    		List<Book> allBooks=bookServ.findBooksBorrowedBy(null);
    		model.addAttribute("allTheBooks", allBooks);
    		List<Book> allBooksBorrowedBy=bookServ.findBooksBorrowedBy(currentUser);
    		model.addAttribute("allTheBooksBorrowedByUser", allBooksBorrowedBy);
    		return "home.jsp";
    	}
    		return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/books/new")
    public String createBook(@ModelAttribute("newBook") Book newBook, HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		User currentUser=userServ.findUserById(userId);
    		return "newBook.jsp";
    	}
    	return "redirect:/";
    }
    
    @PostMapping("/books/new")
    public String addNewBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result,  HttpSession session) {
    	
    	if (result.hasErrors()) {
    		return "newBook.jsp";
    	}
    	else {
    		Long userId= (Long) session.getAttribute("userId");
    		User currentUser=userServ.findUserById(userId);
    		newBook.setPostedBy(currentUser);
    		bookServ.createBook(newBook);
    		return "redirect:/bookmarket";
    	}
    }
    
    @GetMapping("books/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    	Long userId= (Long) session.getAttribute("userId");
    	model.addAttribute("currentUserId", userId);
    	Book theBook = bookServ.findBook(id);
    	Long postedById=theBook.getPostedBy().getId();
    	model.addAttribute("postedByUserId", postedById);
		model.addAttribute("certainBook", theBook);
		return "showBook.jsp";
    	}
    	return "redirect:/";
	}
    
    @GetMapping("books/{id}/edit")
    public String showEditPage(@ModelAttribute("newBook") Book newBook, @PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		Book theBook = bookServ.findBook(id);
    		Long postedById=theBook.getPostedBy().getId();
    		model.addAttribute("certainBook", theBook);
    		System.out.println("posted user id -----------"+postedById);
    		System.out.println("logged user id +++++++++++"+userId);
    		if(userId==postedById) {
    			return "editBook.jsp";
    		}
    		return "redirect:/bookmarket";
    	}
    	
    	return "redirect:/";
    		
    }
    
    @PutMapping("books/{id}/edit")
    public String updateBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
    	if(result.hasErrors()) {
    		return "books/{id}/edit";
    	}
    	else {
    		Long userId= (Long) session.getAttribute("userId");
    		User updatedBy=userServ.findUserById(userId);
    		newBook.setPostedBy(updatedBy);
    		bookServ.updateBook(newBook);
    		return "redirect:/books/{id}";
    	}
    }
    
    @GetMapping("books/{id}/delete")
    public String deleteTheBook(@PathVariable("id") Long id,  HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		Book theBook = bookServ.findBook(id);
    		Long postedById=theBook.getPostedBy().getId();
    		if(userId==postedById) {
    			bookServ.deleteBook(id);
    			return "redirect:/bookmarket";
    		}
    		return "redirect:/";
    	}
    	
    	return "redirect:/";
    }
    
    @DeleteMapping("books/{id}/delete")
    public String deleteThisBook(@PathVariable("id") Long id,  HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		Book theBook = bookServ.findBook(id);
    		Long postedById=theBook.getPostedBy().getId();
    		if(userId==postedById) {
    			bookServ.deleteBook(id);
    			return "redirect:/bookmarket";
    		}
    		return "redirect:/";
    	}
    	
    	return "redirect:/";
    }
    
    @GetMapping("books/{id}/borrow")
    public String borrowTheBook(@PathVariable("id") Long id,  HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		Book theBook = bookServ.findBook(id);
    		Long postedById=theBook.getPostedBy().getId();
    		User borrower=userServ.findUserById(userId);
    		if(userId!=postedById) {
    			theBook.setBorrowedBy(borrower);
    			bookServ.updateBook(theBook);
    			return "redirect:/bookmarket";
    		}
    		return "redirect:/bookmarket";
    	}
    	
    	return "redirect:/";
    }
    
    @GetMapping("books/{id}/return")
    public String returnTheBook(@PathVariable("id") Long id,  HttpSession session) {
    	if (session.getAttribute("userId")!=null) {
    		Long userId= (Long) session.getAttribute("userId");
    		Book theBook = bookServ.findBook(id);
    		Long postedById=theBook.getPostedBy().getId();
    		User borrower=userServ.findUserById(userId);
    		if(userId!=postedById) {
    			theBook.setBorrowedBy(null);
    			bookServ.updateBook(theBook);
    			return "redirect:/bookmarket";
    		}
    		return "redirect:/bookmarket";
    	}
    	
    	return "redirect:/";
    }
    
}