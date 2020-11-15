package com.secure.secureboot.entities;

public class UserEmail {
	
	private String email;
	private User user;
	
	

	@Override
	public String toString() {
		return "UserEmail [email=" + email + ", user=" + user + "]";
	}



	public UserEmail(String email, User user) {
		super();
		this.email = email;
		this.user = user;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public UserEmail() {
		// TODO Auto-generated constructor stub
	}

}
