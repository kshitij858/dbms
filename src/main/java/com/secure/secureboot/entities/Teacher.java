package com.secure.secureboot.entities;

public class Teacher {


	private Integer leavesTaken = 0;
	private Integer teacherId;
	private Integer salary;
	private Integer numberOfLeavesAllowed;
	private User user;
	private String designation;
	public Teacher(Integer leavesTaken, Integer teacherId, Integer salary, Integer numberOfLeavesAllowed, User user,
			String designation) {
		super();
		this.leavesTaken = leavesTaken;
		this.teacherId = teacherId;
		this.salary = salary;
		this.numberOfLeavesAllowed = numberOfLeavesAllowed;
		this.user = user;
		this.designation = designation;
	}







	@Override
	public String toString() {
		return "Teacher [leavesTaken=" + leavesTaken + ", teacherId=" + teacherId + ", salary=" + salary
				+ ", numberOfLeavesAllowed=" + numberOfLeavesAllowed + ", user=" + user + ", designation=" + designation
				+ "]";
	}







	public Integer getLeavesTaken() {
		return leavesTaken;
	}







	public void setLeavesTaken(Integer leavesTaken) {
		this.leavesTaken = leavesTaken;
	}







	public Integer getTeacherId() {
		return teacherId;
	}







	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}







	public Integer getSalary() {
		return salary;
	}







	public void setSalary(Integer salary) {
		this.salary = salary;
	}







	public Integer getNumberOfLeavesAllowed() {
		return numberOfLeavesAllowed;
	}







	public void setNumberOfLeavesAllowed(Integer numberOfLeavesAllowed) {
		this.numberOfLeavesAllowed = numberOfLeavesAllowed;
	}







	public User getUser() {
		return user;
	}







	public void setUser(User user) {
		this.user = user;
	}







	public String getDesignation() {
		return designation;
	}







	public void setDesignation(String designation) {
		this.designation = designation;
	}







	public Teacher() {
		// TODO Auto-generated constructor stub
	}

}
