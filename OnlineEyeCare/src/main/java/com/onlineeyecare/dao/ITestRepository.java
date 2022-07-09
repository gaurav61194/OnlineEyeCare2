package com.onlineeyecare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;

public interface ITestRepository extends JpaRepository<TestModule, Integer> {

	List<TestModule> getTestsByDoctor(int doctorId);


	

}
