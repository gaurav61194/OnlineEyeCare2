package com.onlineeyecare.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Spectacles implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="spectacles_Id")
	private int spectaclesId;
	@Column(name="spectacles_Number")
	private String spectaclesNumber;
	private String spectaclesModel;
	private String spectaclesDescription;
	private double spectaclesCost;
	public int getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public String getSpectaclesModel() {
		return spectaclesModel;
	}
	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}
	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}
	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}
	public double getSpectaclesCost() {
		return spectaclesCost;
	}
	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
	public Spectacles() {
		super();
	}
	public Spectacles(int spectaclesId, String spectaclesNumber, String spectaclesModel, String spectaclesDescription,
			double spectaclesCost) {
		super();
		this.spectaclesId = spectaclesId;
		this.spectaclesNumber = spectaclesNumber;
		this.spectaclesModel = spectaclesModel;
		this.spectaclesDescription = spectaclesDescription;
		this.spectaclesCost = spectaclesCost;
	}
	
	
}