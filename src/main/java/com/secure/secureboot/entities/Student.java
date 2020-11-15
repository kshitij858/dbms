package com.secure.secureboot.entities;


public class Student {
	
	

	private Integer leavesTaken = 0;
	private Integer studentId;
	private Integer feesDue = 0;
	private User user;
	




	public Student(Integer leavesTaken, Integer studentId, Integer feesDue, User user) {
		super();
		this.leavesTaken = leavesTaken;
		this.studentId = studentId;
		this.feesDue = feesDue;
		this.user = user;
	}




	@Override
	public String toString() {
		return "Student [leavesTaken=" + leavesTaken + ", studentId=" + studentId + ", feesDue=" + feesDue + ", user="
				+ user + "]";
	}




	public Integer getLeavesTaken() {
		return leavesTaken;
	}




	public void setLeavesTaken(Integer leavesTaken) {
		this.leavesTaken = leavesTaken;
	}




	public Integer getStudentId() {
		return studentId;
	}




	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}




	public Integer getFeesDue() {
		return feesDue;
	}




	public void setFeesDue(Integer feesDue) {
		this.feesDue = feesDue;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Student() {
		// TODO Auto-generated constructor stub
	}

}
