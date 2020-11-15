package com.secure.secureboot.entities;

import java.sql.Date;

public class Achievement {

	private Integer achievementId;
	private String titleOfAchievement;
	private Date dateOfAchievement;
	private Student student;
	
	
	
	public Achievement(Integer achievementId, String titleOfAchievement, Date dateOfAchievement, Student student) {
		super();
		this.achievementId = achievementId;
		this.titleOfAchievement = titleOfAchievement;
		this.dateOfAchievement = dateOfAchievement;
		this.student = student;
	}



	@Override
	public String toString() {
		return "Achievement [achievementId=" + achievementId + ", titleOfAchievement=" + titleOfAchievement
				+ ", dateOfAchievement=" + dateOfAchievement + ", student=" + student + "]";
	}



	public Integer getAchievementId() {
		return achievementId;
	}



	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}



	public String getTitleOfAchievement() {
		return titleOfAchievement;
	}



	public void setTitleOfAchievement(String titleOfAchievement) {
		this.titleOfAchievement = titleOfAchievement;
	}



	public Date getDateOfAchievement() {
		return dateOfAchievement;
	}



	public void setDateOfAchievement(Date dateOfAchievement) {
		this.dateOfAchievement = dateOfAchievement;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Achievement() {
		// TODO Auto-generated constructor stub
	}

}
