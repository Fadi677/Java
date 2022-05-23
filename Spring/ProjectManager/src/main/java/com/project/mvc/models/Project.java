package com.project.mvc.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="projects")
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotBlank
	private String title;
	
	@NotNull
	@Size(min=3, message="project discription must be at least 3 characters")
	private String description;
	
	@NotNull
	@Future 
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "projects_users", 
            joinColumns = @JoinColumn (name = "project_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id")
        )
    private List<User> projectUsers;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_leader")
    private User projectLeader;
	
    public Project() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<User> getProjectUsers() {
		return projectUsers;
	}

	public void setProjectUsers(List<User> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public User getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(User projectLeader) {
		this.projectLeader = projectLeader;
	}
	
	public void addUserToProject(User user) {
		if(this.projectUsers==null) {
			this.projectUsers=new ArrayList<User>();
		}
		this.projectUsers.add(user);
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
