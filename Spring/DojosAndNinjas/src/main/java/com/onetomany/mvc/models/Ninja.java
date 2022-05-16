package com.onetomany.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ninjaFirstName;
    private String ninjaLastName;
    private int ninjaAge;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {
        
    }
    
    public Ninja(String ninjaFirstName, String ninjaLastName, int ninjaAge) {
    	this.ninjaFirstName=ninjaFirstName;
    	this.ninjaLastName=ninjaLastName;
    	this.ninjaAge=ninjaAge;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNinjaFirstName() {
		return ninjaFirstName;
	}

	public void setNinjaFirstName(String ninjaFirstName) {
		this.ninjaFirstName = ninjaFirstName;
	}

	public String getNinjaLastName() {
		return ninjaLastName;
	}

	public void setNinjaLastName(String ninjaLastName) {
		this.ninjaLastName = ninjaLastName;
	}

	public int getNinjaAge() {
		return ninjaAge;
	}

	public void setNinjaAge(int ninjaAge) {
		this.ninjaAge = ninjaAge;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
    
    
    
}
