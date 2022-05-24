package com.beltexam.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="baby_names")
public class BabyName {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotBlank
	@Size(min=2, message="baby name must be at least 2 characters")
	private String bornName;
	
	@NotNull
	@NotBlank
	private String bornGender;
	
	@NotNull
	@NotBlank
	private String bornOrigin;
	
	@NotNull
	@NotBlank
	private String bornMeaning;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="named_by")
	private User namedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBornName() {
		return bornName;
	}

	public void setBornName(String bornName) {
		this.bornName = bornName;
	}

	public String getBornGender() {
		return bornGender;
	}

	public void setBornGender(String bornGender) {
		this.bornGender = bornGender;
	}

	public String getBornOrigin() {
		return bornOrigin;
	}

	public void setBornOrigin(String bornOrigin) {
		this.bornOrigin = bornOrigin;
	}

	public String getBornMeaning() {
		return bornMeaning;
	}

	public void setBornMeaning(String bornMeaning) {
		this.bornMeaning = bornMeaning;
	}

	
	
	public User getNamedBy() {
		return namedBy;
	}

	public void setNamedBy(User namedBy) {
		this.namedBy = namedBy;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
