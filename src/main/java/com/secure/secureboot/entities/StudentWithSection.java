package com.secure.secureboot.entities;

public class StudentWithSection {
	

	private Section section;
	private Classes classes;
	private Integer studentId;//forkey
	
	

	
	public StudentWithSection(Section section, Classes classes, Integer studentId) {
		super();
		this.section = section;
		this.classes = classes;
		this.studentId = studentId;
	}




	@Override
	public String toString() {
		return "StudentWithSection [section=" + section + ", classes=" + classes + ", studentId=" + studentId + "]";
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




	public Integer getStudentId() {
		return studentId;
	}




	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}




	public StudentWithSection() {
		// TODO Auto-generated constructor stub
	}

}
