package com.onlineeyecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Admin;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;
import com.onlineeyecare.service.IUserService;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private IUserService iuserservice;
	
	@PostMapping("login")
	public ResponseEntity<String> loginUser(@RequestBody User userdto) throws UserNotFoundException, ResourceNotFoundException{
		return new ResponseEntity<String>(iuserservice.signIn(userdto),HttpStatus.OK);
	}
	
	@GetMapping("admin")
	public ResponseEntity<String> adminLogin(@RequestBody Admin admin)
	{
		return new ResponseEntity<String>(iuserservice.adminLogin(admin.getAdminUsername(),admin.getAdminPassword()),HttpStatus.OK);
	}
	@GetMapping("doctor")
	public ResponseEntity<String> doctorLogin(@RequestBody  Doctor doctor)
	{
		return new ResponseEntity<String>(iuserservice.doctorLogin(doctor.getDoctorUsername(),doctor.getDoctorPassword()),HttpStatus.OK);
	}
	@GetMapping("patient")
	public ResponseEntity<String> patientLogin(@RequestBody Patient patient)
	{
		return new ResponseEntity<String>(iuserservice.patientLogin(patient.getPatientUserName(),patient.getPatientPassword()),HttpStatus.OK);
	}
	
	@PostMapping("logout")
	public ResponseEntity<String> logoutUser(@RequestBody User userdto) throws UserNotFoundException, ResourceNotFoundException{
		return new ResponseEntity<String>(iuserservice.signOut(userdto),HttpStatus.OK);	
	}
	
	@PutMapping("updatepassword/{newPassword}")
	public ResponseEntity<User> updatePassword(@PathVariable String newPassword,@RequestBody User userdto) throws UserNotFoundException, PasswordNotMatchException, ResourceNotFoundException{
		return new ResponseEntity<User>(iuserservice.changePassword(newPassword, userdto),HttpStatus.OK);
	}
}
