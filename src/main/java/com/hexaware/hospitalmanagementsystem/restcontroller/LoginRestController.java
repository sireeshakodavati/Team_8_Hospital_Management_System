package com.hexaware.hospitalmanagementsystem.restcontroller;


/*
 * author:Madhuri&Sireesha,
 * lastmodified:19/11/23,
 * Description:RestController for LoginRestController
 * 
*/

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hospitalmanagementsystem.dto.AuthRequest;
import com.hexaware.hospitalmanagementsystem.service.JwtService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginRestController {
	
	Logger logger=LoggerFactory.getLogger(LoginRestController.class);
	@Autowired
	private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
  

	
	public LoginRestController(AuthenticationManager authenticationManager, JwtService jwtService) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/adminlogin")
	public String adminLogin(@RequestBody AuthRequest authRequest) {
        logger.info("Received request for admin login for username: {}", authRequest.getUsername());

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;
		
		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());
            logger.info("Admin login successful for username: {}", authRequest.getUsername());

		}

		else {
            logger.warn("Invalid admin login request for username: {}", authRequest.getUsername());

			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}
        logger.info("Generated token: {}", token);
		return token;
	}
	@PostMapping("/doctorlogin")
	public String doctorLogin(@RequestBody AuthRequest authRequest) {
        logger.info("Received request for doctor login for username: {}", authRequest.getUsername());

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;
		
		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());
            logger.info("Doctor login successful for username: {}", authRequest.getUsername());

		}

		else {
            logger.warn("Invalid Doctor login request for username: {}", authRequest.getUsername());

			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}
        logger.info("Generated token: {}", token);

		return token;
	}
	@PostMapping("/patientlogin")
	public String patientLogin(@RequestBody AuthRequest authRequest) {
        logger.info("Received request for patient login for username: {}", authRequest.getUsername());

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;
		
		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());
            logger.info("Patient login successful for username: {}", authRequest.getUsername());

		}

		else {
            logger.warn("Invalid patient login request for username: {}", authRequest.getUsername());

			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}
        logger.debug("Generated token: {}", token);
		return token;
	}
	
	}
	
	

