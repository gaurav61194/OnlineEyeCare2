package com.onlineeyecare.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineeyecare.dto.TestModule;

public interface ITestRepository extends JpaRepository<TestModule, Integer> {

	public List<TestModule> getTestsByDoctor(int doctorId);
	
	}
