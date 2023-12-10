package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Serviceimplementation for patient
 * 
 */

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.dto.PatientDTO;
import com.hexaware.hospitalmanagementsystem.entity.Patient;
import com.hexaware.hospitalmanagementsystem.repository.PatientRepository;

@Service
public class PatientServiceImp implements IPatientService {
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	private PatientRepository repository;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public PatientServiceImp(PatientRepository repository, PasswordEncoder passwordEncoder) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public PatientDTO addPatient(PatientDTO patientDTO) {
		logger.info("Adding Patient details");
		Patient patient = new Patient();
		patient.setPatientId(patientDTO.getPatientId());
		patient.setUserName(patientDTO.getUserName());
		patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
		patient.setPatientName(patientDTO.getPatientName());
		patient.setDateOfBirth(patientDTO.getDateOfBirth());
		patient.setGender(patientDTO.getGender());
		patient.setMobileNumber(patientDTO.getMobileNumber());
		patient.setDisease(patientDTO.getDisease());
		patient.setNatureOfVisit(patientDTO.getNatureOfVisit());
		patient.setPreferredDate(patientDTO.getPreferredDate());
		patient.setPreferredTime(patientDTO.getPreferredTime());
		Patient patient1=repository.save(patient);
		return new PatientDTO(patient1.getPatientId(),patient1.getUserName(),patient1.getPassword(),patient1.getPatientName(),patient1.getDateOfBirth(),patient1.getGender(),patient1.getMobileNumber(),patient1.getDisease(),patient1.getNatureOfVisit(),patient1.getPreferredDate(),patient1.getPreferredTime());
		
	}

	
	
	@Override
	public PatientDTO updatePatient(PatientDTO patientDTO)
	{
		logger.info("Updating Patient details");
		Patient patient = new Patient();
		patient.setPatientId(patientDTO.getPatientId());
		patient.setUserName(patientDTO.getUserName());
		patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
		patient.setPatientName(patientDTO.getPatientName());
		patient.setDateOfBirth(patientDTO.getDateOfBirth());
		patient.setGender(patientDTO.getGender());
		patient.setMobileNumber(patientDTO.getMobileNumber());
		patient.setDisease(patientDTO.getDisease());
		patient.setNatureOfVisit(patientDTO.getNatureOfVisit());
		patient.setPreferredDate(patientDTO.getPreferredDate());
		patient.setPreferredTime(patientDTO.getPreferredTime());
		Patient patient1=repository.save(patient);
		return new PatientDTO(patient1.getPatientId(),patient1.getUserName(),patient1.getPassword(),patient1.getPatientName(),patient1.getDateOfBirth(),patient1.getGender(),patient1.getMobileNumber(),patient1.getDisease(),patient1.getNatureOfVisit(),patient1.getPreferredDate(),patient1.getPreferredTime());
		
	}
	@Override
	public void deletePatient(int patientId) {
		repository.deleteById(patientId);
		logger.info("Patient record deleted");
	}
	@Override
	public PatientDTO fetchById(int patientId)
	{
		   Patient patient = repository.findById(patientId).orElse(new Patient());
	        return new PatientDTO(
	                patient.getPatientId(),
	                patient.getUserName(),
	                patient.getPassword(),
	                patient.getPatientName(),
	                patient.getDateOfBirth(),
	                patient.getGender(),
	                patient.getMobileNumber(),
	                patient.getDisease(),
	                patient.getNatureOfVisit(),
	                patient.getPreferredDate(),
	                patient.getPreferredTime());
	}
	@Override
	public List<PatientDTO> getAllPatients()
	{
		List<Patient> patients = repository.findAll();
        return patients.stream()
                .map(patient -> new PatientDTO(
                        patient.getPatientId(),
                        patient.getUserName(),
                        patient.getPassword(),
                        patient.getPatientName(),
                        patient.getDateOfBirth(),
                        patient.getGender(),
                        patient.getMobileNumber(),
                        patient.getDisease(),
                        patient.getNatureOfVisit(),
                        patient.getPreferredDate(),
                        patient.getPreferredTime()))
                .collect(Collectors.toList());
	}

}
