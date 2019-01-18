package com.pls.exception;

public class InvalidConnectionDetailsException extends Exception{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		System.out.println("Incorrect Data");
		return super.getMessage();
	}

}
