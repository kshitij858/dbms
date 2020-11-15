package com.secure.secureboot.entities;

import java.sql.Date;

public class Feedback {
	
	private Integer feedbackId;
	private Date dateOfFeedback;
	private User user;
	private String description;
	private String subject;

	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}


	public Feedback(Integer feedbackId, Date dateOfFeedback, User user, String description, String subject) {
		super();
		this.feedbackId = feedbackId;
		this.dateOfFeedback = dateOfFeedback;
		this.user = user;
		this.description = description;
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", dateOfFeedback=" + dateOfFeedback + ", user=" + user
				+ ", description=" + description + ", subject=" + subject + "]";
	}


	public Integer getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}


	public Date getDateOfFeedback() {
		return dateOfFeedback;
	}


	public void setDateOfFeedback(Date dateOfFeedback) {
		this.dateOfFeedback = dateOfFeedback;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

}
