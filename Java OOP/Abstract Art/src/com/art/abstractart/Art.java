package com.art.abstractart;

public abstract class Art {

	public Art() {
		// TODO Auto-generated constructor stub
	}
	
	private String title;
	private String author;
	private String description;
	
	public abstract void viewArt();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
