package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Interface for MedicalTest
 * 
 */

import java.util.List;

import com.hexaware.hospitalmanagementsystem.dto.MedicalTestDTO;

public interface IMedicalTestService {

	public MedicalTestDTO addMedicalTest(MedicalTestDTO medicalTestDTO);

	  public MedicalTestDTO updateMedicalTest(MedicalTestDTO medicalTestDTO);
	  
	  public void deleteMedicalTest(int testId);
	  
	  public MedicalTestDTO getMedicalTestById(int testId);
	  
	  public List<MedicalTestDTO> getAllMedicalTest();
	 
}
