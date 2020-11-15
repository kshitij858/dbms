package com.secure.secureboot.entities;

import java.sql.Date;

public class Transaction {
	
	private Integer transactionId;
	private Date dateOfTransaction;
	private Integer amount;
	private Student student;
	


	public Transaction(Integer transactionId, Date dateOfTransaction, Integer amount, Student student) {
		super();
		this.transactionId = transactionId;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.student = student;
	}



	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", dateOfTransaction=" + dateOfTransaction + ", amount="
				+ amount + ", student=" + student + "]";
	}



	public Integer getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}



	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}



	public void setDateOfTransaction(Date date) {
		this.dateOfTransaction = date;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Transaction() {
		// TODO Auto-generated constructor stub
	}

}
