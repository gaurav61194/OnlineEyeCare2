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
	private ITestRepository repository;

	@Override
	public TestModule addTest(TestModule test) {
		return repository.saveAndFlush(test);
	}

	@Override
	public TestModule updateTest(TestModule test) {
		return repository.saveAndFlush(test);
	}

	@Override
	public TestModule removeTest(int testId) throws TestIdNotFoundException {
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<TestModule> t=Optional.ofNullable(repository.findById(testId).orElseThrow(supplier));
		repository.deleteById(testId);
		return t.get();
	}

	@Override
	public TestModule viewTest(int testId) throws TestIdNotFoundException{
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<TestModule> t=Optional.ofNullable(repository.findById(testId).orElseThrow(supplier));
		return t.get();
	}

	@Override
	public List<TestModule> viewAllTests() {
		return repository.findAll();
	}

	@Override
	public List<TestModule> viewTestsByDoctor(int doctorId) throws DoctorIdNotFoundException {
		return repository.getTestsByDoctor(doctorId);
	}

	
	  @Override public TestModule removeTest(Integer testId) { 
		  return null; 
		  }
	  
	  @Override public List<TestModule> viewTestsByDoctor(Integer doctorId) { 
	  return null; 
	  }
	  
	  @Override public TestModule viewTest(Integer testId) {
	  return null; }
	 
	
}