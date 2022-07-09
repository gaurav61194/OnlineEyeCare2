package com.onlineeyecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dto.Admin;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.exceptions.UserNameAlreadyExistException;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAdminService adminService;

	@Override
	public Patient registerPatient(Patient patient)throws UserNameAlreadyExistException{
		return patientService.addPatient(patient);
	}

	@Override
	public Doctor registerDoctor(Doctor doctor)throws UserNameAlreadyExistException {
		return doctorService.addDoctor(doctor);
	}

	@Override
	public Admin registerAdmin(Admin admin)throws UserNameAlreadyExistException {
		return adminService.addAdmin(admin);
	}
}
