package com.hexaware.hospitalmanagementsystem.entity;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Entity class for DoctorAvailability
 * 
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "doctoravailability_details")

public class DoctorAvailability {
	@Id
	private int doctorAvailabilityId;
	@NotBlank(message = "Dayofweek cannot be blank")
	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String dayOfWeek;
	@Pattern(regexp = "^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$", message = "Invalid time format. Use hh:mm:ss AM/PM")
	private String startTime;
	@Pattern(regexp = "^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$", message = "Invalid time format. Use hh:mm:ss AM/PM")
	private String endTime;

	public DoctorAvailability() {
		super();
	}

	public DoctorAvailability(int doctorAvailabilityId, @NotBlank String dayOfWeek, String startTime, String endTime) {
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
