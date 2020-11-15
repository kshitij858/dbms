package com.secure.secureboot.entities;

public class StudentAndSectionAndClass {
	private int classId;//for key
	private int studentId;//forkey
	private int sectionId;//forkey
	
	
	@Override
	public String toString() {
		return "StudentAndSectionAndClass [classId=" + classId + ", studentId=" + studentId + ", sectionId=" + sectionId
				+ "]";
	}


	public StudentAndSectionAndClass(int classId, int studentId, int sectionId) {
		super();
		this.classId = classId;
		this.studentId = studentId;
		this.sectionId = sectionId;
	}


	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getSectionId() {
		return sectionId;
	}


	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}


	public StudentAndSectionAndClass() {
		// TODO Auto-generated constructor stub
	}

}
