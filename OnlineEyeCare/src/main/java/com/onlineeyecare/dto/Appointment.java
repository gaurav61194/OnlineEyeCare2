package com.onlineeyecare.dto;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	@Id
	@NotEmpty(message="Id is required")
	private Integer appointmentId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfAppointment;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern="hh:mm:ss a")
	LocalTime timeOfAppointment;
	Double consultationFee;
	
	
	public Appointment() {
		super();
	}

	public Appointment(Integer appointmentId, LocalDate dateOfAppointment, LocalTime timeOfAppointment,
			Double consultationFee ) {
		super();
		this.appointmentId = appointmentId;
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		this.consultationFee = consultationFee;
		
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public LocalTime getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(LocalTime timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public Double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
				+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + "]";
	}

	
}
