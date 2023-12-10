package com.hexaware.hospitalmanagementsystem.entity;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Entity class for Admin
 * 
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "admin_details")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	@Pattern(regexp = "[A-Z][a-z]{3,20}")
	private String userName;
	@NotBlank(message = "Password cannot be blank")
	//@Pattern(regexp = "^[A-Za-z]\\d+")
	private String password;
	private String fullName;
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be blank")
	private String email;
	private int phoneNumber;
	private final String roles="ADMIN";
	private String role;

	public Admin() {
		super();
	}

	public Admin(int adminId, @Pattern(regexp = "[A-Z][a-z]{3,20}") String userName, @NotBlank String password,
			String fullName, @Email String email, int phoneNumber) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", fullName="
				+ fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", roles=" + roles + ", role=" + role
				+ "]";
	}
	
	

}