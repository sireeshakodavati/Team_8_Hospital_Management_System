package com.hexaware.hospitalmanagementsystem.dto;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for DoctorAvailability
 * 
 */

public class DoctorAvailabilityDTO {

	private int doctorAvailabilityId;
	private String dayOfWeek;
	private String startTime;
	private String endTime;

	public DoctorAvailabilityDTO() {
		super();
	}

	public DoctorAvailabilityDTO(int doctorAvailabilityId, String dayOfWeek, String startTime, String endTime) {
		super();
		this.doctorAvailabilityId = doctorAvailabilityId;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getDoctorAvailabilityId() {
		return doctorAvailabilityId;
	}

	public void setDoctorAvailabilityId(int doctorAvailabilityId) {
		this.doctorAvailabilityId = doctorAvailabilityId;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
