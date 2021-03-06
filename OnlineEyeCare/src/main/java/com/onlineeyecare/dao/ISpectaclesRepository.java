package com.onlineeyecare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Spectacles;

@Repository(value =  "spectaclesRepository")
public interface ISpectaclesRepository extends JpaRepository<Spectacles, Integer>{	
	@Query("SELECT Spec FROM Spectacles Spec")
	List<Spectacles> findAllSpectacles();
}
