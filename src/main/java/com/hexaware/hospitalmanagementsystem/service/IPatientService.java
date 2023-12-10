package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Interface for patient
 * 
 */

import java.util.List;

import com.hexaware.hospitalmanagementsystem.dto.PatientDTO;

public interface IPatientService {

	public PatientDTO addPatient(PatientDTO patientDTO);

	  public PatientDTO updatePatient(PatientDTO patientDTO);
	  
	  public void deletePatient(int patientId);
	  
	  public PatientDTO fetchById(int patientId);
	  
	  public List<PatientDTO> getAllPatients();
	 
}
