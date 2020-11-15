package com.secure.secureboot.entities;

public class Course {

	private Integer courseId;
	private String courseName;
	private String courseYear;
	private String forClass;
	
	
	
	public Course(Integer courseId, String courseName, String courseYear, String forClass) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseYear = courseYear;
		this.forClass = forClass;
	}



	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseYear=" + courseYear
				+ ", forClass=" + forClass + "]";
	}



	public Integer getCourseId() {
		return courseId;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getCourseYear() {
		return courseYear;
	}



	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}



	public String getForClass() {
		return forClass;
	}



	public void setForClass(String forClass) {
		this.forClass = forClass;
	}



	public Course() {
		// TODO Auto-generated constructor stub
	}

}
