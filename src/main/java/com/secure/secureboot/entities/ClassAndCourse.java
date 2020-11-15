package com.secure.secureboot.entities;

public class ClassAndCourse {

	private Integer classId;
	private Course course ;

	
	
	public ClassAndCourse(Integer classId, Course course) {
		super();
		this.classId = classId;
		this.course = course;
	}



	@Override
	public String toString() {
		return "ClassAndCourse [classId=" + classId + ", course=" + course + "]";
	}



	public Integer getClassId() {
		return classId;
	}



	public void setClassId(Integer classId) {
		this.classId = classId;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public ClassAndCourse() {
		// TODO Auto-generated constructor stub
	}

}
