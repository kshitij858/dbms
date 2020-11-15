package com.secure.secureboot.entities;

public class SectionAndClass {
	
	private Integer classId;//for key
	private Integer teacherId;//for key
	private Section section;
	
	
	
	public SectionAndClass(Integer classId, Integer teacherId, Section section) {
		super();
		this.classId = classId;
		this.teacherId = teacherId;
		this.section = section;
	}



	@Override
	public String toString() {
		return "SectionAndClass [classId=" + classId + ", teacherId=" + teacherId + ", section=" + section + "]";
	}



	public Integer getClassId() {
		return classId;
	}



	public void setClassId(Integer classId) {
		this.classId = classId;
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



	public SectionAndClass() {
		// TODO Auto-generated constructor stub
	}

}
