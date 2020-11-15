package com.secure.secureboot.entities;

public class ClassAndDress {

	private Dress dress;
	private Integer classId;
	

	public ClassAndDress(Dress dress, Integer classId) {
		super();
		this.dress = dress;
		this.classId = classId;
	}


	@Override
	public String toString() {
		return "ClassAndDress [dress=" + dress + ", classId=" + classId + "]";
	}


	public Dress getDress() {
		return dress;
	}


	public void setDress(Dress dress) {
		this.dress = dress;
	}


	public Integer getClassId() {
		return classId;
	}


	public void setClassId(Integer classId) {
		this.classId = classId;
	}


	public ClassAndDress() {
		// TODO Auto-generated constructor stub
	}

}
