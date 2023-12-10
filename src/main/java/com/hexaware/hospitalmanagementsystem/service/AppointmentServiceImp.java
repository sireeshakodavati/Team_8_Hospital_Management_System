package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Serviceimplementation for appointment
 * 
 */


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.dto.AppointmentDTO;
import com.hexaware.hospitalmanagementsystem.entity.Appointment;
import com.hexaware.hospitalmanagementsystem.repository.AppointmentRepository;

import jakarta.transaction.Transactional;

@Service
public class AppointmentServiceImp implements IAppointmentService {
	Logger logger = LoggerFactory.getLogger(AppointmentServiceImp.class);
	private AppointmentRepository repository;

	@Autowired
	public AppointmentServiceImp(AppointmentRepository repository) {
		super();
		this.repository = repository;
	}
	@Transactional
	@Override
	public Appointment addAppointment(AppointmentDTO appointmentDTO) {
//		logger.info("Adding Appointment Details");
//		Appointment appointment = new Appointment();
//		appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
//		appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
//		appointment.setAppointmentId(appointmentDTO.getAppointmentId());
//		appointment.setStatus(appointmentDTO.getStatus());
//		return repository.save(appointment);
		
		try {
	        logger.info("Adding Appointment Details");
	        Appointment appointment = new Appointment();
	        
	        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
			appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
		appointment.setAppointmentId(appointmentDTO.getAppointmentId());
		appointment.setStatus(appointmentDTO.getStatus());
	        return repository.save(appointment);
	    } catch (Exception e) {
	        logger.error("Error adding appointment details", e);
	        throw e;
	    }
	}

	@Override
	public Appointment updateAppointment(AppointmentDTO appointmentDTO) {
		logger.info("Updating Appointment Details");
		Appointment appointment = new Appointment();
		appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
		appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
		appointment.setAppointmentId(appointmentDTO.getAppointmentId());
		appointment.setStatus(appointmentDTO.getStatus());
		return repository.save(appointment);
	}

	@Override
	public void deleteAppointment(int appointmentId) {
		repository.deleteById(appointmentId);
		logger.info("Appointment record deleted");
	}

	@Override
	public AppointmentDTO getAppointmentById(int appointmentId) {
		logger.info("Getting Appointment Details");
		Appointment appointment = repository.findById(appointmentId).orElse(new Appointment());
		return new AppointmentDTO(appointment.getAppointmentId(), appointment.getAppointmentDate(),
				appointment.getAppointmentTime(), appointment.getStatus());
	}

	@Override
	public List<Appointment> getAllAppointment() {
		return repository.findAll();
	}

}