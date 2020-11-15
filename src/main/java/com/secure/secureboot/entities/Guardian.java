package com.secure.secureboot.entities;

public class Guardian {
	
	private Integer guardianId;
	private User user;
	private String isActive;
	@Override
	public String toString() {
		return "Guardian [guardianId=" + guardianId + ", user=" + user + ", isActive=" + isActive + "]";
	}

	public Integer getGuardianId() {
		return guardianId;
	}

	public void setGuardianId(Integer guardianId) {
		this.guardianId = guardianId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Guardian() {
		// TODO Auto-generated constructor stub
	}

}
