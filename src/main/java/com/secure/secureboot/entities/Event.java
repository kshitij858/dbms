package com.secure.secureboot.entities;

import java.sql.Date;

public class Event {
	
	private Integer eventId;
	private String title;
	private String eligibilityDescription;
	private String description;
	private Date eventDate;
	
	
	
	

	public Event(Integer eventId, String title, String eligibilityDescription, String description, Date eventDate) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.eligibilityDescription = eligibilityDescription;
		this.description = description;
		this.eventDate = eventDate;
	}





	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", title=" + title + ", eligibilityDescription=" + eligibilityDescription
				+ ", description=" + description + ", eventDate=" + eventDate + "]";
	}





	public Integer getEventId() {
		return eventId;
	}





	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getEligibilityDescription() {
		return eligibilityDescription;
	}





	public void setEligibilityDescription(String eligibilityDescription) {
		this.eligibilityDescription = eligibilityDescription;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Date getEventDate() {
		return eventDate;
	}





	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}





	public Event() {
		// TODO Auto-generated constructor stub
	}

}
