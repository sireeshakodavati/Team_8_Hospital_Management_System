package com.hexaware.hospitalmanagementsystem.restcontroller;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:restcontroller for patient
 * 
 */

import java.util.List;
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

import com.hexaware.hospitalmanagementsystem.dto.PatientDTO;
import com.hexaware.hospitalmanagementsystem.service.IPatientService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/patient")
@RestController
public class PatientRestController {
	private IPatientService service;

	@Autowired
	public PatientRestController(IPatientService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public PatientDTO addPatient(@Valid @RequestBody PatientDTO patientDTO) {
		return service.addPatient(patientDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('PATIENT','ADMIN')")
	public PatientDTO updatePatient(@RequestBody PatientDTO patientDTO) {
		return service.updatePatient(patientDTO);
	}

	@DeleteMapping("delete/{patientId}")
	@PreAuthorize("hasAnyAuthority('PATIENT','ADMIN')")
	public String deleteById(@PathVariable int patientId) {
		service.deletePatient(patientId);
		return "Patient record deleted";
	}

	@GetMapping("/fetch/{patientId}")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public PatientDTO fetchById(@PathVariable int patientId) {
		return service.fetchById(patientId);
	}

	@GetMapping("/fetchAll")
	@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
	public List<PatientDTO> fetchAllPatients() {
		 return service.getAllPatients();
	}

}
