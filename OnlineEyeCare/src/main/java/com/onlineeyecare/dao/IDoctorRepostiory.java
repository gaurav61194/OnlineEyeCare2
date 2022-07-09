package com.onlineeyecare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Doctor;



@Repository
public interface IDoctorRepostiory extends JpaRepository<Doctor, Integer> {
	
}