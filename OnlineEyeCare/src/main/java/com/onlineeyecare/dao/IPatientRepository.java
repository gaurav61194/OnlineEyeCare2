package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer>  {
	
}
