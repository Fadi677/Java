package com.travel.mvc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.travel.mvc.models.Expense;
import com.travel.mvc.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository=expenseRepository;
	}
	
	//get all expenses
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	//create new expense
	public Expense createExpense(Expense exp) {
		return expenseRepository.save(exp);
	}
	
	 // retrieves an expense
	 public Expense findExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepository.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 }
	
	public Expense updateExpense(Expense exp) {
		return expenseRepository.save(exp);
	}

	public void deleteExpense(Long id) {
		Expense exp=findExpense(id);
		expenseRepository.delete(exp);
	}
	
}
