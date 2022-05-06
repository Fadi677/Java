package com.art.abstractart;

public class Painting extends Art {

	public Painting() {
		// TODO Auto-generated constructor stub
	}
	
	private String paintType; 

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Painting class");
		
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	

}
