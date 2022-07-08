package com.onlineeyecare.service;

import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;

public interface IUserService {
	public Boolean signIn(User user) throws ResourceNotFoundException, UserNotFoundException;
	public Boolean signOut(User user) throws ResourceNotFoundException, UserNotFoundException;
	public User changePassword(String userName, User user) throws ResourceNotFoundException, UserNotFoundException, PasswordNotMatchException;
}
