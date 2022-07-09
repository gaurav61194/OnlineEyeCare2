package com.onlineeyecare.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class SpectacleIdNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public SpectacleIdNotFoundException(String message)
	{
		super(message);
	}

}