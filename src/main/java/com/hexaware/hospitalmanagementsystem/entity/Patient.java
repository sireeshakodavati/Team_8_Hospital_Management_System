package com.hexaware.hospitalmanagementsystem.entity;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Entity class for Patient
 * 
 */

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "patient_details")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String userName;
	//@NotBlank(message = "Password cannot be blank")
	//@Pattern(regexp = "^[A-Za-z]+@\\d+")
	private String password;
	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String patientName;
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
	private String dateOfBirth;
	@NotNull(message = "Gender must be 'M' or 'F'")
	private char gender;
	private int mobileNumber;
	@NotBlank
	private String disease;
	private String natureOfVisit;
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format. Use yyyy-MM-dd")
	private String preferredDate;
	@Pattern(regexp = "^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$", message = "Invalid time format. Use hh:mm:ss AM/PM")
	private String preferredTime;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	private Doctor doctorId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_patientId", referencedColumnName = "patientId")
	private List<Prescription> prescription;
	private final String roles="PATIENT";

	public Patient() {
		super();
	}
	

	public Patient(int patientId, @Pattern(regexp = "[A-Z][a-z]{3,20}") String userName,
			@NotBlank(message = "Password cannot be blank") @Pattern(regexp = "^[A-Za-z]+@\\d+") String password,
			@Pattern(regexp = "[A-Z][a-z]{3,20}") String patientName,
			@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") String dateOfBirth,
			@NotNull(message = "Gender must be 'M' or 'F'") char gender, int mobileNumber, @NotBlank String disease,
			String natureOfVisit,
			@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format. Use yyyy-MM-dd") String preferredDate,
			@Pattern(regexp = "^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$", message = "Invalid time format. Use hh:mm:ss AM/PM") String preferredTime,
			Doctor doctorId, List<Prescription> prescription) {
		super();
		this.patientId = patientId;
		this.userName = userName;
		this.password = password;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.disease = disease;
		this.natureOfVisit = natureOfVisit;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.doctorId = doctorId;
		this.prescription = prescription;
	}


	public Patient(int patientId, @Pattern(regexp = "[A-Z][a-z]{3,20}") String userName,
			@NotBlank(message = "Password cannot be blank") @Pattern(regexp = "^[A-Za-z]+@\\d+") String password,
			@Pattern(regexp = "[A-Z][a-z]{3,20}") String patientName,
			@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") String dateOfBirth,
			@NotNull(message = "Gender must be 'M' or 'F'") char gender, int mobileNumber, @NotBlank String disease,
			String natureOfVisit,
			@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format. Use yyyy-MM-dd") String preferredDate,
			@Pattern(regexp = "^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$", message = "Invalid time format. Use hh:mm:ss AM/PM") String preferredTime) {
		super();
		this.patientId = patientId;
		this.userName = userName;
		this.password = password;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.disease = disease;
		this.natureOfVisit = natureOfVisit;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
	}
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getNatureOfVisit() {
		return natureOfVisit;
	}

	public void setNatureOfVisit(String natureOfVisit) {
		this.natureOfVisit = natureOfVisit;
	}

	public String getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(String preferredDate) {
		this.preferredDate = preferredDate;
	}

	public String getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}

	public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}

	public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}


	public String getRoles() {
		return roles;
	}
	
}
