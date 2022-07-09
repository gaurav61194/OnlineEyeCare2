package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineeyecare.dto.Report;
import com.onlineeyecare.dto.Spectacles;
import com.onlineeyecare.exceptions.PatientIdNotFoundException;
import com.onlineeyecare.exceptions.ReportIdNotFoundException;

public interface IReportService {
	
	public Report addReport(Report report);

	public Report updateReport(Report report)throws ReportIdNotFoundException;

	public Report removeReport(int reportId)throws ReportIdNotFoundException;

	public Report viewReport(int reportId, int patientId)throws ReportIdNotFoundException,PatientIdNotFoundException, PatientIdNotFoundException;

	public List<Report> viewAllReport(LocalDate date);

	public List<Spectacles>  viewSpetacles();


}