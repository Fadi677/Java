package com.travel.mvc.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Valid
	@NotBlank
	@NotNull(message="Expense Title Can't be Blank")
	@Size(min = 4, max = 40, message="Please Enter a Valid Expense")
	private String expenseTitle;
	@NotBlank
	@NotNull(message="Vendor Can't be Blank")
	@Size(min = 4, max = 40, message="Please Enter a Valid Vendor")
	private String vendor;
	@NotNull(message="Amount Can't be Blank")
	@Size(min =1, max = 40, message="Expense should be greater than $0")
	private Double amount;
	@NotNull(message="Amount Can't be Blank")
	@Size(min =10, max = 400, message="Please enter a valid description")
	private String description;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
	public Expense() {
		
	}
	
	public Expense(String expenseTitle, String vendor,Double amount, String description) {
		this.expenseTitle=expenseTitle;
		this.vendor=vendor;
		this.amount=amount;
		this.description=description;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}


	public String getExpenseTitle() {
		return expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    
}
