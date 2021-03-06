package com.onlineeyecare.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Patient {
	@Id
	@GeneratedValue
	@Column(name="patient_Id")
	private int patientId;
	private String patientName;
	private String patientAge;
	
	@NotBlank(message="Mobile Number should not be Empty")
	@Pattern(regexp="(^[6-9][0-9]{9}+$)" ,message="Mobile Number is Not valid")
	private long patientMoile;
	
	@Email
	@NotEmpty(message="Patient Email should not be Empty")
	@Size(min=5, max=20)
	private String patientEmail;
	private LocalDate patientDOB;
	private String patientUserName;
	
	@Column(name="patient_password", length=20)
	@NotEmpty(message="Patient Password should not be Empty")
	@Size(min=5, max=20)
	private String patientPassword;
	
	@Column(name="patient_address", length=30)
	@NotEmpty(message="Patient Address should not be Empty")
	private String patientaddress;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="appointment_Id")
	private List<Appointment> appointment;

	public Patient() {
		super();
	}

	public Patient(int patientId, String patientName, String patientAge, long patientMoile, String patientEmail,
			LocalDate patientDOB, String patientUserName, String patientPassword, String patientaddress,
			List<Appointment> appointment) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientMoile = patientMoile;
		this.patientEmail = patientEmail;
		this.patientDOB = patientDOB;
		this.patientUserName = patientUserName;
		this.patientPassword = patientPassword;
		this.patientaddress = patientaddress;
		this.appointment = appointment;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientMoile() {
		return patientMoile;
	}

	public void setPatientMoile(long patientMoile) {
		this.patientMoile = patientMoile;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientUserName() {
		return patientUserName;
	}

	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getPatientaddress() {
		return patientaddress;
	}

	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMoile=" + patientMoile + ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB
				+ ", patientUserName=" + patientUserName + ", patientPassword=" + patientPassword + ", patientaddress="
				+ patientaddress + ", appointment=" + appointment + "]";
	}
	
	public Patient get(int i) {
		return null;
	}

}
