package com.onlineeyecare.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Report;

@Repository
public interface IReportRepository extends  JpaRepository<Report,Integer>{

	public List<Report> findReportByPatient(int patientId);
	
}