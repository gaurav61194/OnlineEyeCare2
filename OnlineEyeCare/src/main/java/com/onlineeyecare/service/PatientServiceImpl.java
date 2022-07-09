package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dao.IPatientRepository;
import com.onlineeyecare.dao.IReportRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.PatientIdNotFoundException;

@Service
public  class PatientServiceImpl implements IPatientService{
	@Autowired
	private IPatientRepository patientRepo;
	@Autowired
	private IAppointmentRepository  appointRepo;
	@Autowired
	private IReportRepository reportRepo;
	
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.saveAndFlush(patient);
	}
	
	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
		
	}
	
	
	@Override
	public Patient deletePatient(int patientId) throws PatientIdNotFoundException {
		
	Optional<Patient> result=patientRepo.findById(patientId);
		if(result.isPresent())
		{
			patientRepo.deleteById(patientId);
			return  result.get();
		}
		else
		{
			throw new PatientIdNotFoundException("please enter valid patient id");
		}
	}
	
	
	@Override
	public List<Patient> viewPatientList() {

		return patientRepo.findAll();
	}
	
	@Override
	public Patient viewPatient(int patientId) throws PatientIdNotFoundException {

		java.util.Optional<Patient> result=patientRepo.findById(patientId);
		if(result.isPresent())
		{
			patientRepo.findById(patientId);
			return  result.get();
		}
		else
		{
			throw new PatientIdNotFoundException("please enter valid patient id");
		}
	}

	@Override
	public List<Patient> addPatients(List<Patient> patient) {

		return patientRepo.saveAllAndFlush(patient);
	}

	@Override
	public List<Patient> viewAllPatients() {

		return patientRepo.findAll();
	}

	@Override
	public List<Appointment> viewAppointmentsByPatient(int patientId) throws PatientIdNotFoundException {
		
		return appointRepo.findAllAppointmentsByPatientId(patientId);
	}

	@Override
	public List<Report> viewReportsByPatient(int patientId)throws PatientIdNotFoundException{

		return reportRepo.findReportByPatient(patientId); 
	}

	@Override
	public Patient bookAppointmnet(Patient patient) {
		
		return patientRepo.saveAndFlush(patient);
	}
}
