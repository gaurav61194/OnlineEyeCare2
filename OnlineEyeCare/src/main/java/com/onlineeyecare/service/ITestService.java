package com.onlineeyecare.service;

import java.util.List;

import org.aspectj.weaver.ast.Test;

import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.exceptions.TestIdNotFoundException;

public interface ITestService {
	
	TestModule addTest(TestModule a1);
	
	TestModule updateTest(TestModule testModule);

	public TestModule removeTest(Integer testId);

	public List<TestModule> viewTestsByDoctor(Integer doctorId);

	public TestModule viewTest(Integer testId);

	public List<TestModule> viewAllTests();

	public TestModule removeTest(int testId) throws TestIdNotFoundException;

	public TestModule viewTest(int testId) throws TestIdNotFoundException;

	public List<TestModule> viewTestsByDoctor(int doctorId) throws DoctorIdNotFoundException;

	
}
