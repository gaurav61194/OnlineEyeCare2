package com.onlineeyecare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;

@SpringBootTest
public class UserServiceImplTest  {
	@Autowired
	private UserServiceImpl userService;
	User user= new User("Gaurav@123","gau@123","Doctor");
	User user1= new User("Sumit@123","Sumit@123","Doctor");
	User user2=new User("Nihal@96","Nihal@96","Eyespecialist");
	User user3=new User("Aanasaheb@45","Aana@45","Admin");
	User user4=new User("Rushikesh@1","Rushi@1","Doctor");
	User user5=new User("Vishal@135","Vishal@135","Patient");
	
	@Test
	void testchangePassword() throws UserNotFoundException, PasswordNotMatchException, ResourceNotFoundException {
		user=new User("Gaurav@123","gau@123","Doctor");
		
		assertEquals("",userService.changePassword("saiteja@123",user).getPassword());
	}

	@Test
	void testSignIn1() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user));
	}
	
	@Test
	void testsignOut2() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signOut(user));
	}

	@Test
	void testchangePassword1() throws UserNotFoundException,PasswordNotMatchException, ResourceNotFoundException {
		user1=new User("saiteja","tejas94","Doctor");
		assertEquals("tejas94",userService.changePassword("saiteja",user1).getPassword());
		
	}
	
	@Test
	void testSignIn2() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user2));
		
	}
	
	@Test
	void testsignOut3() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signOut(user1));
	}
	
	@Test
	void testchangePassword2() throws UserNotFoundException,PasswordNotMatchException, ResourceNotFoundException {
		user2=new User("nishanth@123","nishanth21","patient");
		assertEquals("nishanth21",userService.changePassword("nishanth@123",user2).getPassword());
	}
	
	@Test
	void testSignIn3() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user2));
	}
	
	@Test
	void testsignOut4() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signOut(user2));
	}
	
	@Test
	void testchangePassword3() throws UserNotFoundException,PasswordNotMatchException, ResourceNotFoundException {
		user3=new User("aravind@34","avi1227","patient");
		assertEquals("avi1227",userService.changePassword("aravind@34",user3).getPassword());
	}
	
	@Test
	void testSignIn4() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user3));
	}

	private void assertTrue(String signIn) {
		// TODO Auto-generated method stub
		
	}
	
}