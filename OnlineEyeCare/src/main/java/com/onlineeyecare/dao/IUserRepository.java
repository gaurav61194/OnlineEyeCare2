package com.onlineeyecare.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.User;

@Repository(value="userRepository")
public interface IUserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByuserName(String name);
}