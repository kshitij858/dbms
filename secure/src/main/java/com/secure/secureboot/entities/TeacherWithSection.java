package com.secure.secureboot.entities;


public class TeacherWithSection {

	Integer teacherId;
	Section section;
	Classes classes;
	Course course;


	


	public TeacherWithSection(Integer teacherId, Section section, Classes classes, Course course) {
		super();
		this.teacherId = teacherId;
		this.section = section;
		this.classes = classes;
		this.course = course;
	}


	@Override
	public String toString() {
		return "TeacherWithSection [teacherId=" + teacherId + ", section=" + section + ", classes=" + classes
				+ ", course=" + course + "]";
	}


	public Integer getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}


	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}


	public Classes getClasses() {
		return classes;
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public TeacherWithSection() {
		// TODO Auto-generated constructor stub
	}

}
