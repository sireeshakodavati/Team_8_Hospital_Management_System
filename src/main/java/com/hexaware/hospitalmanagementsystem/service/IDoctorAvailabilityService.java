package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Interface for DoctorAvailability
 * 
 */

import java.util.List;

import com.hexaware.hospitalmanagementsystem.dto.DoctorAvailabilityDTO;
import com.hexaware.hospitalmanagementsystem.entity.DoctorAvailability;

public interface IDoctorAvailabilityService {

	public DoctorAvailability addDoctorAvailability(DoctorAvailabilityDTO doctorAvailabilityDTO);

	public DoctorAvailability updateDoctorAvailability(DoctorAvailabilityDTO doctorAvailabilityDTO);

	public DoctorAvailability getDoctorAvailabilityById(int doctorAvailabilityId);

	public void deleteDoctorAvailabilityById(int doctorAvailabilityId);

	public List<DoctorAvailability> getAllDoctorAvailability();

}