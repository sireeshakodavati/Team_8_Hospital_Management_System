package com.hexaware.hospitalmanagementsystem.dto;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for Appointment
 * 
*/

public class AppointmentDTO {
	private int appointmentId;
	private String appointmentDate;
	private String appointmentTime;
	private String status;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(int appointmentId, String appointmentDate, String appointmentTime, String status) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
