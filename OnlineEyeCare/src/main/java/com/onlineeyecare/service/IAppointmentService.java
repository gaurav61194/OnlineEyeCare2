package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.ResourceNotFoundException;

public interface IAppointmentService {
	
	public Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException;
	
	public Appointment cancelAppointment(int appointmentId) throws  ResourceNotFoundException, Throwable;

	public Appointment viewAppointment(int appointmentId) throws  ResourceNotFoundException;

	public List<Appointment> viewAllAppointments();

	public List<Appointment> viewAppointments(LocalDate date);

	public Appointment bookAppointment(Appointment appointment);

	public Appointment bookAppointment(IAppointmentService tempAppointment);
	
}