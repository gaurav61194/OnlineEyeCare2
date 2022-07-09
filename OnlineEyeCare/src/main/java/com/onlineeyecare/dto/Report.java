package com.onlineeyecare.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Report implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int reportId;

	private LocalDateTime dateOfReport;
	private String descriptionOfReport;
	private String visualAcuity;
	private String visualAcuityNear;
	private String visualAcuityDistance;
	
	@OneToOne
	@JoinColumn(name="test_Id")
	private TestModule typeOfTest;

	@OneToOne
	@JoinColumn(name="patient_Id")
	private Patient patient;

	public Report() {
		super();
		}

	public Report(int reportId, LocalDateTime dateOfReport, String descriptionOfReport, String visualAcuity,
			String visualAcuityNear, String visualAcuityDistance, TestModule typeOfTest, Patient patient) {
		super();
		this.reportId = reportId;
		this.dateOfReport = dateOfReport;
		this.descriptionOfReport = descriptionOfReport;
		this.visualAcuity = visualAcuity;
		this.visualAcuityNear = visualAcuityNear;
		this.visualAcuityDistance = visualAcuityDistance;
		this.typeOfTest = typeOfTest;
		this.patient = patient;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDateTime getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(LocalDateTime dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}

	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}

	public String getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public String getVisualAcuityNear() {
		return visualAcuityNear;
	}

	public void setVisualAcuityNear(String visualAcuityNear) {
		this.visualAcuityNear = visualAcuityNear;
	}

	public String getVisualAcuityDistance() {
		return visualAcuityDistance;
	}

	public void setVisualAcuityDistance(String visualAcuityDistance) {
		this.visualAcuityDistance = visualAcuityDistance;
	}

	public TestModule getTypeOfTest() {
		return typeOfTest;
	}

	public void setTypeOfTest(TestModule typeOfTest) {
		this.typeOfTest = typeOfTest;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Patient getPatientId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
