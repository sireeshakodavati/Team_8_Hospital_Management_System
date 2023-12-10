package com.hexaware.hospitalmanagementsystem.restcontroller;
/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:restcontroller for doctor
 * 
 */

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hospitalmanagementsystem.dto.DoctorDTO;
import com.hexaware.hospitalmanagementsystem.service.IDoctorService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/doctor")
@RestController
public class DoctorRestController {

	private IDoctorService service;

	@Autowired
	public DoctorRestController(IDoctorService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public DoctorDTO addDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
		return service.addDoctor(doctorDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
	public DoctorDTO updateDoctor(@RequestBody DoctorDTO doctorDTO) {
		return service.updateDoctor(doctorDTO);
	}

	@GetMapping("/getById/{doctorId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public DoctorDTO getDoctorById(@PathVariable int doctorId) {

		return service.getDoctorById(doctorId);

	}

	@GetMapping("/fetchAll")
	@PreAuthorize("hasAnyAuthority('PATIENT','ADMIN')")
	public List<DoctorDTO> fetchAllDoctors() {
	  List<DoctorDTO> doctors = service.getAllDoctors();
	    return doctors.stream()
	            .map(doctor -> new DoctorDTO(doctor.getDoctorId(), doctor.getDoctorName(),
	                    doctor.getGender(), doctor.getSpeciality(), doctor.getExperience(),
	                    doctor.getQualification(), doctor.getDesignation(), doctor.getUserName(),
	                    doctor.getPassword()))
	            .collect(Collectors.toList());
	}

	@DeleteMapping("/delete/{doctorId}")
	@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
	public void deleteDoctorById(@PathVariable int doctorId) {
		service.deleteDoctorById(doctorId);
	}

}
