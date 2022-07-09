package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.ResourceNotFoundException;

public interface IAppointmentService {
	
	Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException;
	
	Appointment cancelAppointment(int appointmentId) throws  ResourceNotFoundException, Throwable;

	Appointment viewAppointment(int appointmentId) throws  ResourceNotFoundException;

	List<Appointment> viewAllAppointments();

	List<Appointment> viewAppointments(LocalDate date);

	Appointment bookAppointment(Appointment appointment);
	
}