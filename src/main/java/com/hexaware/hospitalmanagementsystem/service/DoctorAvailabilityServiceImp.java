package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:ServiceImplementation class for doctoravailability
 * 
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.dto.DoctorAvailabilityDTO;
import com.hexaware.hospitalmanagementsystem.entity.DoctorAvailability;
import com.hexaware.hospitalmanagementsystem.repository.DoctorAvailabilityRepository;

@Service
public class DoctorAvailabilityServiceImp implements IDoctorAvailabilityService {
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	private DoctorAvailabilityRepository repository;

	@Autowired
	public DoctorAvailabilityServiceImp(DoctorAvailabilityRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public DoctorAvailability addDoctorAvailability(DoctorAvailabilityDTO doctorAvailabilityDTO) {
		logger.info("Adding DoctorAvailability Details");
		DoctorAvailability doctoravailability = new DoctorAvailability();
		doctoravailability.setDoctorAvailabilityId(doctorAvailabilityDTO.getDoctorAvailabilityId());
		doctoravailability.setDayOfWeek(doctorAvailabilityDTO.getDayOfWeek());
		doctoravailability.setEndTime(doctorAvailabilityDTO.getEndTime());
		doctoravailability.setStartTime(doctorAvailabilityDTO.getStartTime());
		return repository.save(doctoravailability);

	}

	@Override
	public DoctorAvailability updateDoctorAvailability(DoctorAvailabilityDTO doctorAvailabilityDTO) {
		logger.info("Updating DoctorAvailability Details");
		DoctorAvailability doctoravailability = new DoctorAvailability();
		doctoravailability.setDoctorAvailabilityId(doctorAvailabilityDTO.getDoctorAvailabilityId());
		doctoravailability.setDayOfWeek(doctorAvailabilityDTO.getDayOfWeek());
		doctoravailability.setEndTime(doctorAvailabilityDTO.getEndTime());
		doctoravailability.setStartTime(doctorAvailabilityDTO.getStartTime());
		return repository.save(doctoravailability);
	}

	@Override
	public DoctorAvailability getDoctorAvailabilityById(int doctorAvailabilityId) {
		
		DoctorAvailability doctoravailability = repository.findById(doctorAvailabilityId)
				.orElse(new DoctorAvailability());
		return doctoravailability;

	}

	@Override
	public void deleteDoctorAvailabilityById(int doctorAvailabilityId) {
		repository.deleteById(doctorAvailabilityId);
		logger.info("DoctorAvailability record deleted");

	}

	@Override
	public List<DoctorAvailability> getAllDoctorAvailability() {
		return repository.findAll();
	}

}