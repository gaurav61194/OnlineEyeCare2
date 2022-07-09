package com.onlineeyecare.service;

import java.util.List;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.exceptions.UserNameAlreadyExistException;

	
public interface IDoctorService {
	
	public Doctor addDoctor(Doctor doctor);
	public Doctor viewDoctor(int doctorId)throws DoctorIdNotFoundException;
	public List<Doctor> viewDoctorsList();
	public Doctor updateDoctor(Doctor doctor)throws DoctorIdNotFoundException;
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException;
	public List<Appointment> viewAllAppointments();
	public List<Doctor> viewAllDoctors();


}
