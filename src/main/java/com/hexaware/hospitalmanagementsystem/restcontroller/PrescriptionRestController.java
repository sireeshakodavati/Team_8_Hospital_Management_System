package com.hexaware.hospitalmanagementsystem.restcontroller;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:restcontroller for prescription
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

import com.hexaware.hospitalmanagementsystem.dto.PrescriptionDTO;
import com.hexaware.hospitalmanagementsystem.service.IPrescriptionService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/prescription")
@RestController
public class PrescriptionRestController {
	private IPrescriptionService service;

	@Autowired
	public PrescriptionRestController(IPrescriptionService service) {
		super();
		this.service = service;
	}
	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
	public PrescriptionDTO addPrescription(@Valid @RequestBody PrescriptionDTO prescriptionDTO) {
		return service.addPrescription(prescriptionDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public PrescriptionDTO updatePrescription(@RequestBody PrescriptionDTO prescriptionDTO) {
		return service.updatePrescription(prescriptionDTO);
	}

	@GetMapping("/getById/{prescriptionId}")
	@PreAuthorize("hasAnyAuthority('PATIENT','DOCTOR')")
	public PrescriptionDTO getPrescriptionById(@PathVariable int prescriptionId) {

		return service.getPrescriptionById(prescriptionId);

	}

	@GetMapping("/fetchAll")
	@PreAuthorize("hasAnyAuthority('ADMIN','PATIENT','DOCTOR')")
	public List<PrescriptionDTO> fetchAllPrescriptions() {
		 List<PrescriptionDTO> prescriptions = service.getAllPrescription();
	        return prescriptions.stream()
	                .map(prescription -> new PrescriptionDTO(prescription.getPrescriptionId(),
	                        prescription.getMedicineName(), prescription.getPrice()))
	                .collect(Collectors.toList());
	}

	@DeleteMapping("/delete/{prescriptionId}")
	@PreAuthorize("hasAnyAuthority('DOCTOR','ADMIN')")
	public void deletePrescription(@PathVariable int prescriptionId) {
		service.deletePrescription(prescriptionId);
	}

}
