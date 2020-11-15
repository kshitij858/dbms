package com.secure.secureboot.entities;

public class UserPhoneNumber {

	private String phoneNumber;
	private User user;
	
	
	public UserPhoneNumber(String phoneNumber, User user) {
		super();
		this.phoneNumber = phoneNumber;
		this.user = user;
	}


	@Override
	public String toString() {
		return "UserPhoneNumber [phoneNumber=" + phoneNumber + ", user=" + user + "]";
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	public UserPhoneNumber() {
		// TODO Auto-generated constructor stub
	}

}
