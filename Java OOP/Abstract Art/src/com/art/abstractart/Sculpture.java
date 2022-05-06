package com.art.abstractart;

public class Sculpture extends Art {

	public Sculpture() {
		// TODO Auto-generated constructor stub
	}
	
	private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Sculpture class");
		
	} 

	

}
