package com.bean;

/*
 * Book class contains the information about the book
 */
public class Book {
	
	private int bookID;
	private String bookName;
	private String authorName;
	
	public Book() {
		super();
	}

	
	@Override
	public String toString() {
		return "\nBook [bookID=" + bookID + ", bookName=" + bookName
				+ ", authorName=" + authorName + "]";
	}


	public Book(int bookID, String bookName, String authorName) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
	}


	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	

}
