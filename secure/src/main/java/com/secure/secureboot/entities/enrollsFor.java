package com.secure.secureboot.entities;

public class enrollsFor {

	private Integer studentId;
	private Integer courseId;
	private String eligibility;
	private String grade;
	private String isChecked;
	
	
	
	public enrollsFor(Integer studentId, Integer courseId, String eligibility, String grade, String isChecked) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.eligibility = eligibility;
		this.grade = grade;
		this.isChecked = isChecked;
	}



	@Override
	public String toString() {
		return "enrollsFor [studentId=" + studentId + ", courseId=" + courseId + ", eligibility=" + eligibility
				+ ", grade=" + grade + ", isChecked=" + isChecked + "]";
	}



	public Integer getStudentId() {
		return studentId;
	}



	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}



	public Integer getCourseId() {
		return courseId;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}



	public String getEligibility() {
		return eligibility;
	}



	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getIsChecked() {
		return isChecked;
	}



	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}



	public enrollsFor() {
		// TODO Auto-generated constructor stub
	}

}
