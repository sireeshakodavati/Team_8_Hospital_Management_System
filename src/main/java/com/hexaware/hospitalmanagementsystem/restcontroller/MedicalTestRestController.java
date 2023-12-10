package com.hexaware.hospitalmanagementsystem.restcontroller;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:RestController for MedicalTest
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.hexaware.hospitalmanagementsystem.dto.MedicalTestDTO;
import com.hexaware.hospitalmanagementsystem.exception.MedicalTestNotFoundException;
import com.hexaware.hospitalmanagementsystem.service.IMedicalTestService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/medicaltest")
@RestController
public class MedicalTestRestController {

	private IMedicalTestService service;

	@Autowired
	public MedicalTestRestController(IMedicalTestService service) {
		super();
		this.service = service;
	}

	@PostMapping(value = "/add")
	@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
	public MedicalTestDTO addMedicalTest(@Valid @RequestBody MedicalTestDTO medicalTestDTO) {
		return service.addMedicalTest(medicalTestDTO);
	}

	@PutMapping(value = "/update")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public MedicalTestDTO updateMedicalTest(@RequestBody MedicalTestDTO medicalTestDTO) {
		return service.updateMedicalTest(medicalTestDTO);
	}

	@DeleteMapping("delete/{testId}")
	@PreAuthorize("hasAnyAuthority('DOCTOR')")
	public String deleteMedicalTestById(@PathVariable int testId) {
		service.deleteMedicalTest(testId);
		return "MedicalTest record deleted";
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN','PATIENT','DOCTOR')")
	public List<MedicalTestDTO> getAllMedicalTest() {
		return service.getAllMedicalTest();
	}

	@GetMapping("get/{testId}")
	@PreAuthorize("hasAnyAuthority('PATIENT','DOCTOR')")
	public MedicalTestDTO getMedicalTestById(@PathVariable int testId) throws MedicalTestNotFoundException {
		MedicalTestDTO medicalTestDTO = service.getMedicalTestById(testId);

		if (medicalTestDTO.getTestId() == 0) {
			throw new MedicalTestNotFoundException(HttpStatus.BAD_REQUEST, "medicaltest not found for testId");
		}
		return medicalTestDTO;
	}

}
