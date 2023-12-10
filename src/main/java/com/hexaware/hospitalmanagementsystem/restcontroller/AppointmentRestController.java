package com.hexaware.hospitalmanagementsystem.restcontroller;
/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:restcontroller for appointment
 * 
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.hexaware.hospitalmanagementsystem.dto.AppointmentDTO;
import com.hexaware.hospitalmanagementsystem.entity.Appointment;
import com.hexaware.hospitalmanagementsystem.exception.AppointmentValidationException;
import com.hexaware.hospitalmanagementsystem.service.IAppointmentService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/appointment")
@RestController
public class AppointmentRestController {
	Logger logger = LoggerFactory.getLogger(AppointmentRestController.class);
	private IAppointmentService service;

	@Autowired
	public AppointmentRestController(IAppointmentService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('PATIENT')")
	public Appointment addAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
		return service.addAppointment(appointmentDTO);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('PATIENT','DOCTOR')")
	public Appointment updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		return service.updateAppointment(appointmentDTO);
	}

	@DeleteMapping("/delete/{appointmentId}")
	@PreAuthorize("hasAnyAuthority('PATIENT','DOCTOR')")
	public void deleteAppointment(@PathVariable int appointmentId)

	{
		service.deleteAppointment(appointmentId);
	}

	@GetMapping("/get/{appointmentId}")
	@PreAuthorize("hasAnyAuthority('PATIENT','DOCTOR','ADMIN')")
	public AppointmentDTO getAppointmentById(@PathVariable int appointmentId) throws AppointmentValidationException {
		AppointmentDTO appointmentDTO = service.getAppointmentById(appointmentId);
		if (appointmentDTO.getAppointmentId() == 0) {
			throw new AppointmentValidationException(HttpStatus.BAD_REQUEST, "Appointment NotFound with appointmentId");
		}
		return appointmentDTO;

	}

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
	public List<Appointment> getAllAppointment() {
		return service.getAllAppointment();

	}

}