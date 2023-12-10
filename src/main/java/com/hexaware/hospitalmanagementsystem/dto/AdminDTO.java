package com.hexaware.hospitalmanagementsystem.dto;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:DTO class for Admin
 * 
*/

public class AdminDTO {
	private int adminId;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private int phoneNumber;
	private String role;

	public AdminDTO() {
		super();
	}

	public AdminDTO(int adminId, String userName, String password, String fullName, String email, int phoneNumber,
			String role) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
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

	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", fullName="
				+ fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", role=" + role + "]";
	}

}
