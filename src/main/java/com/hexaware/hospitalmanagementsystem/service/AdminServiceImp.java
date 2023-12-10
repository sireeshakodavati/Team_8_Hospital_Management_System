package com.hexaware.hospitalmanagementsystem.service;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:ServiceImplementation class for admin
 * 
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.dto.AdminDTO;
import com.hexaware.hospitalmanagementsystem.entity.Admin;
import com.hexaware.hospitalmanagementsystem.repository.AdminRepository;

@Service
public class AdminServiceImp implements IAdminService {
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	private PasswordEncoder passwordEncoder;

	private AdminRepository repository;

	@Autowired
	public AdminServiceImp(PasswordEncoder passwordEncoder, AdminRepository repository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.repository = repository;
	}

	@Override
	public Admin addAdmin(AdminDTO adminDTO)
	{
		// System.out.println(adminDTO); logger.info("Adding Admin details");
		Admin admin = new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setEmail(adminDTO.getEmail());
		admin.setFullName(adminDTO.getFullName());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
		admin.setPhoneNumber(adminDTO.getPhoneNumber());
		admin.setRole(adminDTO.getRole()); // System.out.println(admin); 
		return repository.save(admin);

	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO) {
		logger.info("Updating Admin details");
		Admin admin = new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setEmail(adminDTO.getEmail());
		admin.setFullName(adminDTO.getFullName());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
		admin.setPhoneNumber(adminDTO.getPhoneNumber());
		admin.setRole(adminDTO.getRole());
		return repository.save(admin);
	}

	@Override
	public void deleteAdmin(int adminId) {
		repository.deleteById(adminId);
		logger.info("Admin record deleted");
	}

	@Override
	public AdminDTO getAdminById(int adminId) {
		logger.info("Getting Admin details");
		Admin admin = repository.findById(adminId).orElse(new Admin());
		return new AdminDTO(admin.getAdminId(), admin.getUserName(), admin.getPassword(), admin.getFullName(),
				admin.getEmail(), admin.getPhoneNumber(), admin.getRole());
	}

	@Override
	public Admin getAdminByName(String fullName) {

		return repository.findByfullName(fullName);

	}

	@Override
	public List<Admin> getAllAdmin() {

		return repository.findAll();
	}

}
