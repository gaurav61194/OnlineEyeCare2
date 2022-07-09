package com.onlineeyecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Admin;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.exceptions.UserNameAlreadyExistException;
import com.onlineeyecare.service.IRegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private IRegistrationService rs;
	@PostMapping("/patient")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) throws UserNameAlreadyExistException
	{
		return new ResponseEntity<Patient>(rs.registerPatient(patient),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor) throws UserNameAlreadyExistException
	{
		return new ResponseEntity<Doctor>(rs.registerDoctor(doctor),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) throws UserNameAlreadyExistException
	{
		return new ResponseEntity<Admin>(rs.registerAdmin(admin),HttpStatus.ACCEPTED);
	}
}

