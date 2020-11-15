package com.secure.secureboot.entities;

import java.util.Date;

public class ParticipationRequest {
	
	private Integer participationRequestId;
	private Date dateOfParticipationRequest;
	private String titleOfParticipationRequest;
	private User user;

	
	
	
	public ParticipationRequest(Integer participationRequestId, Date dateOfParticipationRequest,
			String titleOfParticipationRequest, User user) {
		super();
		this.participationRequestId = participationRequestId;
		this.dateOfParticipationRequest = dateOfParticipationRequest;
		this.titleOfParticipationRequest = titleOfParticipationRequest;
		this.user = user;
	}




	@Override
	public String toString() {
		return "ParticipationRequest [participationRequestId=" + participationRequestId
				+ ", dateOfParticipationRequest=" + dateOfParticipationRequest + ", titleOfParticipationRequest="
				+ titleOfParticipationRequest + ", user=" + user + "]";
	}




	public Integer getParticipationRequestId() {
		return participationRequestId;
	}




	public void setParticipationRequestId(Integer participationRequestId) {
		this.participationRequestId = participationRequestId;
	}




	public Date getDateOfParticipationRequest() {
		return dateOfParticipationRequest;
	}




	public void setDateOfParticipationRequest(Date dateOfParticipationRequest) {
		this.dateOfParticipationRequest = dateOfParticipationRequest;
	}




	public String getTitleOfParticipationRequest() {
		return titleOfParticipationRequest;
	}




	public void setTitleOfParticipationRequest(String titleOfParticipationRequest) {
		this.titleOfParticipationRequest = titleOfParticipationRequest;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public ParticipationRequest() {
		// TODO Auto-generated constructor stub
	}

}
