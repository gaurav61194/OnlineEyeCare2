package com.onlineeyecare.exceptions;

public class InvalidAppointmentException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidAppointmentException() {
		
	}
	public InvalidAppointmentException(String message) {
		super(message);
	}
}
