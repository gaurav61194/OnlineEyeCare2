package com.onlineeyecare.exceptions;

public class PasswordNotMatchException extends Exception {

	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException() {
		
	}
	public PasswordNotMatchException(String msg) {
		super(msg);
	}

}
