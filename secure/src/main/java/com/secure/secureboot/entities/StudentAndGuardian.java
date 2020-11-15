package com.secure.secureboot.entities;

public class StudentAndGuardian {

	private Integer studentId;
	private Guardian guardian;
	private String relationship;
	
	
	

	public StudentAndGuardian(Integer studentId, Guardian guardian, String relationship) {
		super();
		this.studentId = studentId;
		this.guardian = guardian;
		this.relationship = relationship;
	}




	@Override
	public String toString() {
		return "StudentAndGuardian [studentId=" + studentId + ", guardian=" + guardian + ", relationship="
				+ relationship + "]";
	}




	public Integer getStudentId() {
		return studentId;
	}




	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}




	public Guardian getGuardian() {
		return guardian;
	}




	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}




	public String getRelationship() {
		return relationship;
	}




	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}




	public StudentAndGuardian() {
		// TODO Auto-generated constructor stub
	}

}
