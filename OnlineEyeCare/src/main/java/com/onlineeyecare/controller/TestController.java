package com.onlineeyecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.exceptions.TestIdNotFoundException;
import com.onlineeyecare.service.ITestService;

@RestController
@RequestMapping("test/api/v1")
public class TestController {

	@Autowired
	private ITestService ts;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/tests")
	public ResponseEntity<List<TestModule>> getAllTests(){
		List<TestModule> test= ts.viewAllTests();
		if(test.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TestModule>>(test, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/tests")
	public ResponseEntity<TestModule> InsertTest(@RequestBody TestModule tests){
		TestModule test= ts.addTest(tests);
		if(test==null) {
			return new ResponseEntity("Sorry! tests not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(test, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/tests/{testId}")
	public ResponseEntity<TestModule> deleteTest(
			@PathVariable("testId")Integer testId)throws TestIdNotFoundException{
		TestModule tests= ts.removeTest(testId);
		if(tests==null) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(tests, HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/tests/{testId}")
	public ResponseEntity<TestModule> findTest(
			@PathVariable("testId")Integer testId)throws TestIdNotFoundException{
		TestModule test= ts.viewTest(testId);
		if(test==null) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(test, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/tests")
	public ResponseEntity<TestModule> updateTest(
			 @RequestBody TestModule test){
		TestModule tests= ts.updateTest(test);
		if(tests==null)
		{
			return new ResponseEntity("Sorry! test not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(tests, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getTests/{doctorId}")
	public ResponseEntity<List<TestModule>> viewTests(@PathVariable("doctorId")Integer doctorId)throws DoctorIdNotFoundException{
		List<TestModule> doc=ts.viewTestsByDoctor(doctorId);
		if(doc.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TestModule>>(doc, HttpStatus.OK);
	}
    
}
