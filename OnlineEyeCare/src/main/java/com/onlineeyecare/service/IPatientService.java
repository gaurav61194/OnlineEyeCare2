package com.onlineeyecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.PatientIdNotFoundException;
import com.onlineeyecare.exceptions.UserNameAlreadyExistException;

@Service
public interface IPatientService {
	
	public Patient addPatient(Patient patient) throws UserNameAlreadyExistException ;
	
	public List<Patient> addPatients(List<Patient> patient);
	
	public List<Patient> viewPatientList();
	
	public List<Patient> viewAllPatients();
	
	public Patient viewPatient(int patientId) throws PatientIdNotFoundException;
	
	public Patient updatePatient(Patient patient);
	
	public Patient deletePatient(int patientId) throws PatientIdNotFoundException;
	
	public List<Appointment> viewAppointmentsByPatient(int patientId) throws PatientIdNotFoundException;
	
	public List<Report> viewReportsByPatient(int patientId) throws PatientIdNotFoundException;
	
	public Patient bookAppointmnet(Patient patients);
}
