package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Interface for doctor
 * 
 */

import java.util.List;

import com.hexaware.hospitalmanagementsystem.dto.DoctorDTO;

public interface IDoctorService {
	
	  public DoctorDTO addDoctor(DoctorDTO doctorDTO);

	  public DoctorDTO updateDoctor(DoctorDTO doctorDTO);
	  
	  public DoctorDTO getDoctorById(int doctorId);
		
      public List<DoctorDTO> getAllDoctors();
      
	  public void deleteDoctorById(int doctorId);
	 
	
}
