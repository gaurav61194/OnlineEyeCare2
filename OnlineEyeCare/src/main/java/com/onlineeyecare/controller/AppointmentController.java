package com.onlineeyecare.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.service.IAppointmentService;

@RestController
@RequestMapping("/v1")
public class AppointmentController {
	@Autowired
	IAppointmentService appointmentService;

	@PostMapping("/bookappointment")
	public Appointment bookAppointment(@Valid @RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(appointment);
	}
	
	@PutMapping("/updateappointment/{id}")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws Throwable {
		return appointmentService.updateAppointment(appointment);
	}

	@DeleteMapping("/cancelappointment/{id}")
	public Appointment cancelAppointment(@PathVariable int id) throws Throwable {
		return appointmentService.cancelAppointment(id);
	}
	
	@GetMapping("/viewallappointments")
	public List<Appointment> listallappointments() {
		return appointmentService.viewAllAppointments();
	}
	 
	@GetMapping("/viewappointment/{id}")
	public Appointment viewAppointment(@PathVariable int id) throws Throwable {
		return appointmentService.viewAppointment(id);
	}
	
	@GetMapping("/viewallappointmentbydate")
	public List<Appointment> listallappointments(@RequestParam(value="date")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate date) {
		return appointmentService.viewAppointments(date);
	}

}


