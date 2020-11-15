package com.secure.secureboot.entities;

public class Dress {

	private String dressDescription;
	private int dressId;
	
	
	
	public Dress(String dressDescription, int dressId) {
		super();
		this.dressDescription = dressDescription;
		this.dressId = dressId;
	}



	@Override
	public String toString() {
		return "Dress [dressDescription=" + dressDescription + ", dressId=" + dressId + "]";
	}



	public String getDressDescription() {
		return dressDescription;
	}



	public void setDressDescription(String dressDescription) {
		this.dressDescription = dressDescription;
	}



	public int getDressId() {
		return dressId;
	}



	public void setDressId(int dressId) {
		this.dressId = dressId;
	}



	public Dress() {
		// TODO Auto-generated constructor stub
	}

}
