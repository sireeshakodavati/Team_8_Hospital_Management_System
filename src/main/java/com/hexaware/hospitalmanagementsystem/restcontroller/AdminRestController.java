package com.hexaware.hospitalmanagementsystem.restcontroller;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:RestController for Admin
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hospitalmanagementsystem.dto.AdminDTO;
import com.hexaware.hospitalmanagementsystem.entity.Admin;
import com.hexaware.hospitalmanagementsystem.exception.AdminNotFoundException;
import com.hexaware.hospitalmanagementsystem.service.IAdminService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/admin")
@RestController
public class AdminRestController {
	private IAdminService service;

	@Autowired
	public AdminRestController(IAdminService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public Admin addAdmin(@Valid @RequestBody AdminDTO adminDTO) {

		return service.addAdmin(adminDTO);
	}

	@PutMapping(value = "/update")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Admin updateAdmin(@RequestBody AdminDTO adminDTO) {
		return service.updateAdmin(adminDTO);
	}

	@GetMapping("getbyid/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AdminDTO getAdminById(@PathVariable int adminId) throws AdminNotFoundException {
		AdminDTO adminDTO = service.getAdminById(adminId);
		if (adminDTO.getAdminId() == 0) {
			throw new AdminNotFoundException(HttpStatus.BAD_REQUEST, "admin not found with adminid");
		}
		return adminDTO;
	}

	@DeleteMapping("delete/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void deleteAdmin(int adminId) {
		service.deleteAdmin(adminId);
	}

	@GetMapping("/getbyname/{fullName}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Admin getByName(@PathVariable String fullName) {
		return service.getAdminByName(fullName);
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<Admin> getAllAdmin() {
		return service.getAllAdmin();
	}
}
