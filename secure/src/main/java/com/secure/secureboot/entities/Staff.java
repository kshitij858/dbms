package com.secure.secureboot.entities;

public class Staff {
	

	private Integer leavesTaken = 0;
	private Integer staffId;
	private Integer salary;
	private Integer numberOfLeavesAllowed;
	private User user;
	private String designation;
	
	
	
	






	public Staff(Integer leavesTaken, Integer staffId, Integer salary, Integer numberOfLeavesAllowed, User user,
			String designation) {
		super();
		this.leavesTaken = leavesTaken;
		this.staffId = staffId;
		this.salary = salary;
		this.numberOfLeavesAllowed = numberOfLeavesAllowed;
		this.user = user;
		this.designation = designation;
	}










	@Override
	public String toString() {
		return "Staff [leavesTaken=" + leavesTaken + ", staffId=" + staffId + ", salary=" + salary
				+ ", numberOfLeavesAllowed=" + numberOfLeavesAllowed + ", user=" + user + ", designation=" + designation
				+ "]";
	}










	public Integer getLeavesTaken() {
		return leavesTaken;
	}










	public void setLeavesTaken(Integer leavesTaken) {
		this.leavesTaken = leavesTaken;
	}










	public Integer getStaffId() {
		return staffId;
	}










	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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










	public Staff() {
		// TODO Auto-generated constructor stub
	}

}
