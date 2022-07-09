package com.onlineeyecare.dto;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
	@Id
	@NotEmpty(message="Id is required")
	@Column(name="appointment_Id")
	private Integer appointmentId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfAppointment;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern="hh:mm:ss a")
	LocalTime timeOfAppointment;
	Double consultationFee;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="doctor_Id")
	Doctor doctorId;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="patient_Id")
	@JsonIgnore
	Patient patientId;
	
	public Appointment() {
		super();
	}
	public Appointment(@NotEmpty(message = "Id is required") Integer appointmentId, LocalDate dateOfAppointment,
			LocalTime timeOfAppointment, Double consultationFee, Doctor doctorId, Patient patientId) {
		super();
		this.appointmentId = appointmentId;
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		this.consultationFee = consultationFee;
		this.doctorId = doctorId;
		this.patientId = patientId;
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
	public Doctor getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}
	public Patient getPatientId() {
		return patientId;
	}
	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
				+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + ", doctorId="
				+ doctorId + ", patientId=" + patientId + "]";
	}
	
	
	
}
