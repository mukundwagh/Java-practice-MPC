package com.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Defaulter {

	/*
	 * Defaulter class is used to check the student 
	 * who didn't return the book
	 */
	private Transaction transaction;
	private int fine;
	private Date retDate;
	public int getFine() {
		return fine;
	}


	public void setFine(int fine) {
		this.fine = fine;
	}


	public Date getRetDate() {
		return retDate;
	}


	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}


	public Defaulter() {
		super();
	}

	
	@Override
	public String toString() {
		return "\nDefaulter [transaction=" + transaction + ", fine=" + fine
				+ ", retDate=" + retDate + "]";
	}


	public Defaulter(Transaction transaction, int fine, Date retDate) {
		super();
		this.transaction = transaction;
		this.fine = fine;
		this.retDate = retDate;
	}


	public Date getIssueDates(){
		return transaction.getIssueDate();
	}
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}	
	
}
