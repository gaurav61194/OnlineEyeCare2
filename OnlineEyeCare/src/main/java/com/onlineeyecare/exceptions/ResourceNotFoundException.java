package com.onlineeyecare.exceptions;


public class ResourceNotFoundException extends Exception
{
	private static final long serialVersionUID = 6130601241343107961L;

	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}