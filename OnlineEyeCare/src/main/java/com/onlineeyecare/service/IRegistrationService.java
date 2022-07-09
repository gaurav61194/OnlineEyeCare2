package com.onlineeyecare.service;

import org.springframework.stereotype.Service;

import com.onlineeyecare.dto.Admin;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.exceptions.UserNameAlreadyExistException;

@Service
public interface IRegistrationService {
	//patient registration
	public Patient registerPatient(Patient patient)throws UserNameAlreadyExistException; 
    //doctor registration
	public Doctor registerDoctor(Doctor doctor)throws UserNameAlreadyExistException; 
    //admin registration
	public Admin registerAdmin(Admin admin) throws UserNameAlreadyExistException; 
}
