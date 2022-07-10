package com.onlineeyecare.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Appointment;
@Repository(value="appointmentRepository")
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {

	List<Appointment> findAllAppointmentsByPatientId(int patientId);

}
