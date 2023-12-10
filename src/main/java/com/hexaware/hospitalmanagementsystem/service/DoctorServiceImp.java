package com.hexaware.hospitalmanagementsystem.service;
/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Serviceimplementation for doctor
 * 
 */

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hexaware.hospitalmanagementsystem.dto.DoctorDTO;
import com.hexaware.hospitalmanagementsystem.entity.Doctor;
import com.hexaware.hospitalmanagementsystem.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements IDoctorService {
	Logger logger = LoggerFactory.getLogger(DoctorServiceImp.class);
	private DoctorRepository repository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public DoctorServiceImp(DoctorRepository repository, PasswordEncoder passwordEncoder) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public DoctorDTO addDoctor(DoctorDTO doctorDTO) {
		logger.info("Adding Doctor details");
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctorDTO.getDoctorName());
		doctor.setDoctorId(doctorDTO.getDoctorId());
		doctor.setGender(doctorDTO.getGender());
		doctor.setSpeciality(doctorDTO.getSpeciality());
		doctor.setExperience(doctorDTO.getExperience());
		doctor.setQualification(doctorDTO.getQualification());
		doctor.setDesignation(doctorDTO.getDesignation());
		doctor.setUserName(doctorDTO.getUserName());
		doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
		Doctor doctor1 = repository.save(doctor);
		return new DoctorDTO(doctor1.getDoctorId(), doctor1.getDoctorName(), doctor1.getGender(),
				doctor1.getSpeciality(), doctor1.getExperience(), doctor1.getQualification(), doctor1.getDesignation(),
				doctor1.getUserName(), doctor1.getPassword());

	}

	@Override
	public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {

		logger.info("Updating Doctor details");
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctorDTO.getDoctorName());
		doctor.setDoctorId(doctorDTO.getDoctorId());
		doctor.setGender(doctorDTO.getGender());
		doctor.setSpeciality(doctorDTO.getSpeciality());
		doctor.setExperience(doctorDTO.getExperience());
		doctor.setQualification(doctorDTO.getQualification());
		doctor.setDesignation(doctorDTO.getDesignation());
		doctor.setUserName(doctorDTO.getUserName());
		doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
		Doctor doctor1 = repository.save(doctor);
		return new DoctorDTO(doctor1.getDoctorId(), doctor1.getDoctorName(), doctor1.getGender(),
				doctor1.getSpeciality(), doctor1.getExperience(), doctor1.getQualification(), doctor1.getDesignation(),
				doctor1.getUserName(), doctor1.getPassword());
	}

	@Override
	public List<DoctorDTO> getAllDoctors()

	{
		List<Doctor> doctors = repository.findAll();
	    return doctors.stream()
	            .map(doctor -> new DoctorDTO(doctor.getDoctorId(), doctor.getDoctorName(),
	                    doctor.getGender(), doctor.getSpeciality(), doctor.getExperience(),
	                    doctor.getQualification(), doctor.getDesignation(), doctor.getUserName(),
	                    doctor.getPassword()))
	            .collect(Collectors.toList());
	}

	@Override
	public DoctorDTO getDoctorById(int doctorId) {
		logger.info("Getting Doctor details");
		DoctorDTO doctorDTO = new DoctorDTO();
		Doctor doctor = repository.findById(doctorId).orElse(new Doctor());

		if (doctor != null) {
			doctorDTO.setDoctorId(doctor.getDoctorId());
			doctorDTO.setDoctorName(doctor.getDoctorName());
			doctorDTO.setGender(doctor.getGender());
			doctorDTO.setSpeciality(doctor.getSpeciality());
			doctorDTO.setExperience(doctor.getExperience());
			doctorDTO.setQualification(doctor.getQualification());
			doctorDTO.setDesignation(doctor.getDesignation());
			doctorDTO.setUserName(doctor.getUserName());
			doctorDTO.setPassword(passwordEncoder.encode(doctor.getPassword()));
		}
		return doctorDTO;

	}

	@Override
	public void deleteDoctorById(int doctorId) {
		repository.deleteById(doctorId);
		logger.info("doctor record deleted");
	}

}
