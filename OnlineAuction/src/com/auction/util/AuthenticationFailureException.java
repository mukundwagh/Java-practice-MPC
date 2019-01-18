package com.auction.util;

public class AuthenticationFailureException extends Exception {
	
	private static final long serialVersionUID = 6250567966112969656L;

	public AuthenticationFailureException(String msg) {
		super(msg);
	}
}
