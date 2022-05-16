package com.travel.mvc.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import com.travel.mvc.models.Expense;
import com.travel.mvc.services.ExpenseService;

@Controller
public class ExpensesController {
	private final ExpenseService expenseService;
	
	public ExpensesController(ExpenseService expenseService) {
		this.expenseService=expenseService;
	}
	
	//render index page
	@RequestMapping("/expenses")
	public String index(Model model,@ModelAttribute("expenses") Expense expenseObjects) {
		List<Expense> allExpenses=expenseService.allExpenses();
		model.addAttribute("expenseObject", allExpenses);
		return "index.jsp";
	}
	
	//create new expense
	@PostMapping("/expenses/new")
	public String createExpense(@Valid @ModelAttribute("expenses") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
	}
	
	@GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {  
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("thisExpense", expense);
        return "edit.jsp";
    }
	
	@PutMapping("/expenses/{id}")
    public String update( @Valid @ModelAttribute("expenses") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "/expenses/{id}/edit";
        } else {
        	expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
        model.addAttribute("thisExpense", expense);
        return "show.jsp";
	}
	
	@DeleteMapping("/expenses/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
}
