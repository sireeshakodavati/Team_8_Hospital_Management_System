package com.hexaware.hospitalmanagementsystem.dto;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for Patient
 * 
 */


public class PatientDTO {

	private int patientId;
	private String userName;
	private String password;
	private String patientName;
	private String dateOfBirth;
	private char gender;
	private int mobileNumber;
	private String disease;
	private String natureOfVisit;
	private String preferredDate;
	private String preferredTime;

	public PatientDTO(int patientId, String userName, String password, String patientName, String dateOfBirth,
			char gender, int mobileNumber, String disease, String natureOfVisit, String preferredDate,
			String preferredTime) {
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

	

	public PatientDTO() {
		super();
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


}
