package com.secure.secureboot.entities;

public class Classes {
	
	private String className;
	private String classYear;
	private Integer noOfClassesHeld;
	private Integer classId;
	private Integer fees;
	

	
	public Classes(String className, String classYear, Integer noOfClassesHeld, Integer classId, Integer fees) {
		super();
		this.className = className;
		this.classYear = classYear;
		this.noOfClassesHeld = noOfClassesHeld;
		this.classId = classId;
		this.fees = fees;
	}



	@Override
	public String toString() {
		return "Classes [className=" + className + ", classYear=" + classYear + ", noOfClassesHeld=" + noOfClassesHeld
				+ ", classId=" + classId + ", fees=" + fees + "]";
	}



	public String getClassName() {
		return className;
	}



	public void setClassName(String className) {
		this.className = className;
	}



	public String getClassYear() {
		return classYear;
	}



	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}



	public Integer getNoOfClassesHeld() {
		return noOfClassesHeld;
	}



	public void setNoOfClassesHeld(Integer noOfClassesHeld) {
		this.noOfClassesHeld = noOfClassesHeld;
	}



	public Integer getClassId() {
		return classId;
	}



	public void setClassId(Integer classId) {
		this.classId = classId;
	}



	public Integer getFees() {
		return fees;
	}



	public void setFees(Integer fees) {
		this.fees = fees;
	}



	public Classes() {
		// TODO Auto-generated constructor stub
	}

}
