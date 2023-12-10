package com.hexaware.hospitalmanagementsystem.entity;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Entity class for Doctor
 * 
 */

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "doctor_details")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	// @Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String doctorName;
	@NotNull(message = "Gender must be 'M' or 'F'")
	private char gender;
	@NotBlank
	private String speciality;
	@Positive(message = "Value must be positive")
	private int experience;
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid characters in the input")
	private String qualification;
	private String designation;
	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String userName;
	//@NotBlank(message = "Password cannot be blank")
	//@Pattern(regexp = "^[A-Za-z]+@\\d+")
	private String password;
	@OneToMany(targetEntity = Appointment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_doctorId", referencedColumnName = "doctorId")
	private List<Appointment> appointment;
	//@JsonIgnore
	 private final String roles="DOCTOR";

	public Doctor(int doctorId, @Pattern(regexp = "[A-Z][a-z]{3,20}") String doctorName, char gender,
			@NotBlank String speciality, int experience, String qualification, String designation, String userName,
			String password, List<Appointment> appointment) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.gender = gender;
		this.speciality = speciality;
		this.experience = experience;
		this.qualification = qualification;
		this.designation = designation;
		this.userName = userName;
		this.password = password;
		this.appointment = appointment;
	}

	public Doctor() {
		super();
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public String getRoles() {
		return roles;
	}
	
}