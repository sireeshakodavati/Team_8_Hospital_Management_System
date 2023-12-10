package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Interface for Admin
 * 
 */

import java.util.List;

import com.hexaware.hospitalmanagementsystem.dto.AdminDTO;
import com.hexaware.hospitalmanagementsystem.entity.Admin;

public interface IAdminService {
	public Admin addAdmin(AdminDTO adminDTO);

	public Admin updateAdmin(AdminDTO adminDTO);

	public void deleteAdmin(int adminId);

	public Admin getAdminByName(String fullName);

	public AdminDTO getAdminById(int adminId);

	public List<Admin> getAllAdmin();
}
