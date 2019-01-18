package com.bean;

import java.sql.Date;

/*
 * Transaction class contains the information about the students
 * who issued the book
 * and also maintain the relevant Book information
 */
public class Transaction {
	private int studID;
	private String studName;
	private Date issueDate;
	private Date returnDate;
	private int bookID;
	private Book book;

	
	public Transaction(int studID, String studName, Date issueDate,
			Date returnDate, int bookID, Book book) {
		super();
		this.studID = studID;
		this.studName = studName;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.bookID = bookID;
		this.book = book;
	}

	public Transaction() {
		super();
	}

	public int getStudID() {
		return studID;
	}

	public void setStudID(int studID) {
		this.studID = studID;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	@Override
	public String toString() {
		return "\nTransaction [studID=" + studID + ", studName=" + studName
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", bookID=" + bookID + ", book=" + book + "]";
	}


	


	
	
	

}
