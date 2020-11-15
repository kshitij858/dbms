package com.secure.secureboot.entities;

import java.sql.Date;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String role;
	private String firstName;
	private String middleName;
	private String lastName;
	private String houseNumber;
	private String streetName;
	private String city;
	private Integer pincode;
	private String adharNumber;
	private String category;
	private String bloodGroup;
	private String gender;
	private Date registrationDate;

	
	public User(Integer userId, String username, String password, String role, String firstName, String middleName,
			String lastName, String houseNumber, String streetName, String city, Integer pincode, String adharNumber,
			String category, String bloodGroup, String gender, Date registrationDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
		this.adharNumber = adharNumber;
		this.category = category;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.registrationDate = registrationDate;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", houseNumber=" + houseNumber + ", streetName=" + streetName + ", city=" + city + ", pincode="
				+ pincode + ", adharNumber=" + adharNumber + ", category=" + category + ", bloodGroup=" + bloodGroup
				+ ", gender=" + gender + ", registrationDate=" + registrationDate + "]";
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Integer getPincode() {
		return pincode;
	}


	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}


	public String getAdharNumber() {
		return adharNumber;
	}


	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}

}
