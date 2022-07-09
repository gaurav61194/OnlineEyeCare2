package com.onlineeyecare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.service.IAppointmentService;
import com.onlineeyecare.service.IDoctorService;
import com.onlineeyecare.service.ITestService;

@RestController
@RequestMapping("/onlineeyeclinic")
public class DoctorController {
  @Autowired
	IDoctorService doctorService;
  @Autowired
	ITestService testService;
  @Autowired
  IAppointmentService appointmentService;

  @PostMapping("/adddoctor")
  public Doctor addDoctor(@Valid @RequestBody Doctor doctor)
  {
  	return doctorService.addDoctor(doctor);
  }

  @GetMapping("/viewdoctorslist")
  public List<Doctor>viewDoctorsList()
  {
  	return doctorService.viewDoctorsList();
  }
	

	@GetMapping("/viewdoctor/{id}")
	public Doctor viewDoctor(@PathVariable int id) throws DoctorIdNotFoundException
	{
		return doctorService.viewDoctor(id);
	}

	
	@DeleteMapping("/deletedoctor/{id}")
	public Doctor deleteDoctor(@PathVariable int id) throws DoctorIdNotFoundException
	{
		return doctorService.deleteDoctor(id);
	}
	

	@PutMapping("/updatedoctor")
	public Doctor updateDoctor(@RequestBody Doctor doctor) throws DoctorIdNotFoundException
	{
		return doctorService.updateDoctor(doctor);
	}
	
	@PostMapping("/createTest")
	public TestModule createTest(@RequestBody TestModule test) {
		return testService.addTest(test);
	}
	
	
	@GetMapping("/viewAppointments")
	public List<Appointment> viewAllAppointments() {
		return appointmentService.viewAllAppointments();
	}
	
}
