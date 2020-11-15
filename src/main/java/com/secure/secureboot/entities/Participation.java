package com.secure.secureboot.entities;

import java.sql.Date;

public class Participation {
	
	private Integer participationId;
	private Date dateOfParticipation;
	private String typeOfParticipation;
	private Student student;

	
	
	public Participation(Integer participationId, Date dateOfParticipation, String typeOfParticipation,
			Student student) {
		super();
		this.participationId = participationId;
		this.dateOfParticipation = dateOfParticipation;
		this.typeOfParticipation = typeOfParticipation;
		this.student = student;
	}



	@Override
	public String toString() {
		return "Participation [participationId=" + participationId + ", dateOfParticipation=" + dateOfParticipation
				+ ", typeOfParticipation=" + typeOfParticipation + ", student=" + student + "]";
	}



	public Integer getParticipationId() {
		return participationId;
	}



	public void setParticipationId(Integer participationId) {
		this.participationId = participationId;
	}



	public Date getDateOfParticipation() {
		return dateOfParticipation;
	}



	public void setDateOfParticipation(Date dateOfParticipation) {
		this.dateOfParticipation = dateOfParticipation;
	}



	public String getTypeOfParticipation() {
		return typeOfParticipation;
	}



	public void setTypeOfParticipation(String typeOfParticipation) {
		this.typeOfParticipation = typeOfParticipation;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Participation() {
		// TODO Auto-generated constructor stub
	}

}
