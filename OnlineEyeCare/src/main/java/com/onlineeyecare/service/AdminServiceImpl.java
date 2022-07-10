package com.onlineeyecare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAdminRepository;
import com.onlineeyecare.dto.Admin;
import com.onlineeyecare.exceptions.AdminIdNotFoundException;
import com.onlineeyecare.exceptions.UserNameAlreadyExistException;

@Service(value="adminServiceImpl")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) throws UserNameAlreadyExistException {
		List<Admin> admins=this.viewAllAdmins();
		for(Admin ad:admins)
		{
			if(ad.getAdminUsername().equals(admin.getAdminUsername()))
			{
				throw new UserNameAlreadyExistException("username already exist.....Please modify your username !");
			}
		}
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public List<String> getAdmins() {
		List<String> usernameList=new ArrayList<String>();
		List<Admin> adminList=adminRepo.findAll();
		for(Admin admin:adminList)
		{
			usernameList.add(admin.getAdminUsername());
		}
		return usernameList;
	}

	@Override
	public List<Admin> viewAllAdmins() {
		return adminRepo.findAll();
	}

	@Override
	public Admin removeAdmin(int adminId) throws AdminIdNotFoundException {
		Supplier<AdminIdNotFoundException> supplier=()->new AdminIdNotFoundException("no admin found with this id");
	  Optional<Admin> a=Optional.ofNullable(adminRepo.findById(adminId).orElseThrow(supplier));
	  adminRepo.deleteById(adminId);
	  return a.get();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public Admin viewAdmin(int adminId) throws AdminIdNotFoundException {
		Supplier<AdminIdNotFoundException> supplier=()->new AdminIdNotFoundException("no admin found with this id");
		Optional<Admin> a=Optional.ofNullable(adminRepo.findById(adminId).orElseThrow(supplier));
		  return a.get();
	}
}

