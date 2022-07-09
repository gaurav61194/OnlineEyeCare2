package com.onlineeyecare.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AdminIdNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public AdminIdNotFoundException(String message)
	{
		super(message);
	}

}