package com.onlineeyecare.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TestModule implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="test_Id")
	private int testId;
	@Column(name="test_Name")
	private String testName;
	private String testType;
	private String testDescription;;
	private double testCost;
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	private Doctor doctor;

	public TestModule() {
		super();
	}

	public TestModule(int testId, String testName, String testType, String testDescription, double testCost,
			Doctor doctor) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testType = testType;
		this.testDescription = testDescription;
		this.testCost = testCost;
		this.doctor = doctor;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public double getTestCost() {
		return testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "TestModule [testId=" + testId + ", testName=" + testName + ", testType=" + testType
				+ ", testDescription=" + testDescription + ", testCost=" + testCost + ", doctor=" + doctor + "]";
	}
	
	
}