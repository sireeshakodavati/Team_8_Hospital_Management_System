package com.hexaware.hospitalmanagementsystem.restcontroller;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:RestController for DoctorAvailability
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

import com.hexaware.hospitalmanagementsystem.dto.DoctorAvailabilityDTO;
import com.hexaware.hospitalmanagementsystem.entity.DoctorAvailability;
import com.hexaware.hospitalmanagementsystem.service.IDoctorAvailabilityService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/doctoravailability")
public class DoctorAvailabilityRestController {
	private IDoctorAvailabilityService service;

	@Autowired
	public DoctorAvailabilityRestController(IDoctorAvailabilityService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public DoctorAvailability addDoctorAvailability(@Valid @RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO) {
		return service.addDoctorAvailability(doctorAvailabilityDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public DoctorAvailability updateDoctorAvailability(@RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO) {
		return service.updateDoctorAvailability(doctorAvailabilityDTO);
	}

	@GetMapping("get/{doctorAvailabilityId}")
	@PreAuthorize("hasAnyAuthority('PATIENT')")
	public DoctorAvailability getDoctorAvailabilityById(@PathVariable int doctorAvailabilityId) {
		return service.getDoctorAvailabilityById(doctorAvailabilityId);
	}

	@DeleteMapping("delete/{doctorAvailabilityId}")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public String deleteDoctorAvailabilityById(@PathVariable int doctorAvailabilityId) {
		service.deleteDoctorAvailabilityById(doctorAvailabilityId);
		return "record deleted";
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN','PATIENT','DOCTOR')")
	public List<DoctorAvailability> getAllDoctorAvailability() {
		return service.getAllDoctorAvailability();
	}

}