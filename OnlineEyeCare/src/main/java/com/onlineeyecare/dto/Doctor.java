package com.onlineeyecare.dto;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@GeneratedValue
	@Column(name="doctor_Id")
	public int doctorId;
	@NotNull(message="Name is mandatory")
	private String doctorName;
	private String doctorConsultationTime;
	private long doctorMobile;
	
	@Email(message= "oops...Email Format is not Corrected")
	@NotEmpty(message="Email column cannot be empty")
	
	private String doctorEmail;
	 @NotBlank(message = "username is mandatory")
	private String doctorUsername;
	 @Size(min =6,max=15,message="Size must be between 6 to 15")
	private String doctorPassword;
	private String doctorAddress;
	
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name="test_Id")
	public List<TestModule> tests;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}

	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}

	public long getDoctorMobile() {
		return doctorMobile;
	}

	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public List<TestModule> getTests() {
		return tests;
	}

	public void setTests(List<TestModule> tests) {
		this.tests = tests;
	}

	public Doctor(int doctorId,
			@NotNull(message = "Name is mandatory") @Size(min = 5, message = "Size must be atleast 5") String doctorName,
			String doctorConsultationTime, long doctorMobile,
			@Email(message = "oops...Email Format is not Corrected") @NotEmpty(message = "Email column cannot be empty") String doctorEmail,
			@NotBlank(message = "username is mandatory") String doctorUsername,
			@Size(min = 6, max = 15, message = "Size must be between 6 to 15") String doctorPassword,
			String doctorAddress, List<TestModule> tests) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.doctorUsername = doctorUsername;
		this.doctorPassword = doctorPassword;
		this.doctorAddress = doctorAddress;
		this.tests = tests;
	}

	public Doctor() {
		super();
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorConsultationTime="
				+ doctorConsultationTime + ", doctorMobile=" + doctorMobile + ", doctorEmail=" + doctorEmail
				+ ", doctorUsername=" + doctorUsername + ", doctorPassword=" + doctorPassword + ", doctorAddress="
				+ doctorAddress + ", tests=" + tests + "]";
	}

	
}
