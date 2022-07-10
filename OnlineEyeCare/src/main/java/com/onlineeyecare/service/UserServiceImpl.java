package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IUserRepository;
import com.onlineeyecare.dto.Admin;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.UserNotFoundException;

@Service(value="userServiceImpl")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IUserRepository iuserRepository;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPatientService patientService;
	
	public String adminLogin(String username, String password) {
		String detail=null;
		List<Admin> admins=adminService.viewAllAdmins();
		for(Admin admin:admins)
		{
			if(admin.getAdminUsername().equals(username) && admin.getAdminPassword().equals(password))
			{
				detail="you are logged in as : "+username;
				break;
			}
			else if(admin.getAdminUsername().equals(username) && admin.getAdminPassword()!=password)
			{
				detail="username exist but password doesn't matches";
				break;
			}
			else if(admin.getAdminUsername()!=username)
			{
				detail="username not exist. Please register !!!!";
			}
		}
		return detail;
	}

	@Override
	public String patientLogin(String username, String password) {
		String detail=null;
		List<Patient> patients=patientService.viewAllPatients();
		for(Patient patient:patients)
		{
			if(patient.getPatientUserName().equals(username) && patient.getPatientPassword().equals(password))
			{
				detail="you are logged in as : "+username;
				break;
			}
			else if(patient.getPatientUserName().equals(username) && patient.getPatientPassword()!=password)
			{
				detail="username exist but password doesn't matches";
				break;
				
			}
			else if(patient.getPatientUserName()!=username)
			{
				detail="username not exist. Please register !!!!";
		
			}
		}
	
		return detail;
	}

	@Override
	public String doctorLogin(String username, String password) {
		String detail=null;
		List<Doctor> doctors=doctorService.viewAllDoctors();
		for(Doctor doctor:doctors)
		{
			if(doctor.getDoctorUsername().equals(username) && doctor.getDoctorPassword().equals(password))
			{
				detail="you are logged in as : "+username;
				break;
			}
			else if(doctor.getDoctorUsername().equals(username) && doctor.getDoctorPassword()!=password)
			{
				detail="username exist but password doesn't matches";
				break;
			}
			else if(doctor.getDoctorUsername()!=username)
			{
				detail="username not exist. Please register !!!!";
			}
		}
		return detail;
	}
	
	@Override
	public String signIn(User user) throws UserNotFoundException{
		String massage = "User Not Found";
		Boolean status = false;
		Optional<User> resultUser = iuserRepository.findByuserName(user.getUserName());
		if(resultUser.isPresent()) {
			if((resultUser.get().getPassword().equals(user.getPassword())))
			{
					status=true;
					return "Welcome You have login";
			} 
			else
			
			throw new UserNotFoundException("User Not Found");
	}
	return massage;
}
	
	@Override
	public String signOut(User user) throws UserNotFoundException {
		String massage = "User Not Found";
		Boolean status=false;
		Optional<User> resultUser= iuserRepository.findByuserName(user.getUserName());

		if (!resultUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		else if(resultUser.get().getPassword().equals(user.getPassword())) {
			 status = true;
			 return "Your logout";
		}
		return massage;
	}
	
	@Override
	public User changePassword(String newPassword, User user) throws UserNotFoundException, PasswordNotMatchException {
		Optional<User> resultUser= iuserRepository.findByuserName(user.getUserName());
		if(resultUser.isPresent()) {
			if((resultUser.get().getPassword().equals(user.getPassword())))
			{
				user.setPassword(newPassword);
				return iuserRepository.save(user);
				
			}
			else
			{
				throw new PasswordNotMatchException("Password Not matched please enter valid password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}	
	}

	
}
	


