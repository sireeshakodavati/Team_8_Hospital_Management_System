package com.hexaware.hospitalmanagementsystem.dto;


/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for Doctor
 * 
 */

public class DoctorDTO {
	private int doctorId;
	private String doctorName;
	private char gender;
	private String speciality;
	private int experience;
	private String qualification;
	private String designation;
	private String userName;
	private String password;

	public DoctorDTO(int doctorId, String doctorName, char gender, String speciality, int experience,
			String qualification, String designation, String userName, String password) {
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
	}

	public DoctorDTO() {
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

}
