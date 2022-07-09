package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.ITestRepository;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.exceptions.TestIdNotFoundException;

@Service
public class TestServiceImpl implements ITestService{
	
	@Autowired
	private ITestRepository testRepo;

	@Override
	public TestModule addTest(TestModule test) {
		return testRepo.saveAndFlush(test);
	}

	@Override
	public TestModule updateTest(TestModule test) {
		return testRepo.saveAndFlush(test);
	}

	@Override
	public TestModule removeTest(int testId) throws TestIdNotFoundException {
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<TestModule> t=Optional.ofNullable(testRepo.findById(testId).orElseThrow(supplier));
		testRepo.deleteById(testId);
		return t.get();
	}

	@Override
	public TestModule viewTest(int testId) throws TestIdNotFoundException{
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<TestModule> t=Optional.ofNullable(testRepo.findById(testId).orElseThrow(supplier));
		return t.get();
	}

	@Override
	public List<TestModule> viewAllTests() {
		return testRepo.findAll();
	}

	@Override
	public List<TestModule> viewTestsByDoctor(int doctorId) throws DoctorIdNotFoundException {
		return testRepo.getTestsByDoctor(doctorId);
	}

	@Override
	public TestModule removeTest(Integer testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestModule> viewTestsByDoctor(Integer doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestModule viewTest(Integer testId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}