package com.hexaware.hospitalmanagementsystem.config;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.hospitalmanagementsystem.entity.Admin;
import com.hexaware.hospitalmanagementsystem.entity.Doctor;
import com.hexaware.hospitalmanagementsystem.entity.Patient;
import com.hexaware.hospitalmanagementsystem.repository.AdminRepository;
import com.hexaware.hospitalmanagementsystem.repository.DoctorRepository;
import com.hexaware.hospitalmanagementsystem.repository.PatientRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService  {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	  { 
		Optional<Admin> adminInfo = adminRepository.findByUserName(username);
    	if(adminInfo.isPresent()) {
    		return adminInfo.map(AdminInfoUserDetails::new)
    	            .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
    	}

    	Optional<Doctor> doctorInfo = doctorRepository.findByUserName(username);
    	if(doctorInfo.isPresent()) {
    		return doctorInfo.map(DoctorInfoUserDetails::new)
    	            .orElseThrow(() -> new UsernameNotFoundException("doctor not found: " + username));
    	}
    	
    	Optional<Patient> patientInfo = patientRepository.findByUserName(username);
    	if(patientInfo.isPresent()) {
    		return patientInfo.map(PatientInfoUserDetails::new)
    	            .orElseThrow(() -> new UsernameNotFoundException("patient not found: " + username));
    	}
    	
    	
    	throw new UsernameNotFoundException("User not found: " + username);
  
    }
}
