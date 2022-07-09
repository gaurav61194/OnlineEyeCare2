package com.onlineeyecare.exceptions;

public class DoctorIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
		public DoctorIdNotFoundException(){
			
		}
		public DoctorIdNotFoundException(String message) {
			super(message);
		}
}