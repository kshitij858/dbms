package com.secure.secureboot.entities;

import java.sql.Date;

public class PositionOfResponsibility {
	
	private Integer positionOfResponsibilityId;
	private Date dateOfPositionOfResponsibility;
	private Date till;
	private String title;
	private User user;
	
	

	

	



	public PositionOfResponsibility(Integer positionOfResponsibilityId, Date dateOfPositionOfResponsibility, Date till,
			String title, User user) {
		super();
		this.positionOfResponsibilityId = positionOfResponsibilityId;
		this.dateOfPositionOfResponsibility = dateOfPositionOfResponsibility;
		this.till = till;
		this.title = title;
		this.user = user;
	}









	@Override
	public String toString() {
		return "PositionOfResponsibility [positionOfResponsibilityId=" + positionOfResponsibilityId
				+ ", dateOfPositionOfResponsibility=" + dateOfPositionOfResponsibility + ", till=" + till + ", title="
				+ title + ", user=" + user + "]";
	}









	public Integer getPositionOfResponsibilityId() {
		return positionOfResponsibilityId;
	}









	public void setPositionOfResponsibilityId(Integer positionOfResponsibilityId) {
		this.positionOfResponsibilityId = positionOfResponsibilityId;
	}









	public Date getDateOfPositionOfResponsibility() {
		return dateOfPositionOfResponsibility;
	}









	public void setDateOfPositionOfResponsibility(Date dateOfPositionOfResponsibility) {
		this.dateOfPositionOfResponsibility = dateOfPositionOfResponsibility;
	}









	public Date getTill() {
		return till;
	}









	public void setTill(Date till) {
		this.till = till;
	}









	public String getTitle() {
		return title;
	}









	public void setTitle(String title) {
		this.title = title;
	}









	public User getUser() {
		return user;
	}









	public void setUser(User user) {
		this.user = user;
	}









	public PositionOfResponsibility() {
		// TODO Auto-generated constructor stub
	}

}
