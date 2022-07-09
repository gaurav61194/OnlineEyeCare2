package com.onlineeyecare.service;

import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;

public interface IUserService {
	
	public String signIn(User user) throws ResourceNotFoundException, UserNotFoundException;
	
	public String signOut(User user) throws ResourceNotFoundException, UserNotFoundException;
	
	public User changePassword(String userName, User user) throws ResourceNotFoundException, UserNotFoundException, PasswordNotMatchException;
	
	public String adminLogin(String adminUsername, String adminPassword);
	
	public String patientLogin(String username, String password);
	
	public String doctorLogin(String username, String password);
}
