package com.hexaware.hospitalmanagementsystem.service;
/*
 * author:Madhuri&Sireesha,
 * lastmodified:18/11/23,
 * Description:Interface for appointment
 * 
 */
import java.util.List;

import com.hexaware.hospitalmanagementsystem.dto.AppointmentDTO;
import com.hexaware.hospitalmanagementsystem.entity.Appointment;

public interface IAppointmentService {

	public Appointment addAppointment(AppointmentDTO appointmentDTO);

	public Appointment updateAppointment(AppointmentDTO appointmentDTO);

	public void deleteAppointment(int appointmentId);

	public AppointmentDTO getAppointmentById(int appointmentId);

	public List<Appointment> getAllAppointment();

}