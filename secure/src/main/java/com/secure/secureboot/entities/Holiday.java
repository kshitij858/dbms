package com.secure.secureboot.entities;

import java.sql.Date;

public class Holiday {

	private Integer holidayId;
	private String title;
	private String eligibilityDescription;
	private String description;
	private Date holidayDate;
	
	
	
	
	public Holiday(Integer holidayId, String title, String eligibilityDescription, String description,
			Date holidayDate) {
		super();
		this.holidayId = holidayId;
		this.title = title;
		this.eligibilityDescription = eligibilityDescription;
		this.description = description;
		this.holidayDate = holidayDate;
	}




	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", title=" + title + ", eligibilityDescription="
				+ eligibilityDescription + ", description=" + description + ", holidayDate=" + holidayDate + "]";
	}




	public Integer getHolidayId() {
		return holidayId;
	}




	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
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




	public Date getHolidayDate() {
		return holidayDate;
	}




	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}




	public Holiday() {
		// TODO Auto-generated constructor stub
	}

}
