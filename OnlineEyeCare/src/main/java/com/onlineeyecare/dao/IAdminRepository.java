package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Integer> {

}
