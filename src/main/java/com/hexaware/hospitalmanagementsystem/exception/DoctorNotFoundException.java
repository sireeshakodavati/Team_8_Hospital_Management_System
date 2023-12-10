package com.hexaware.hospitalmanagementsystem.exception;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:17/11/23,
 * Description:exception class for doctor
 * 
 */

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class DoctorNotFoundException extends ResponseStatusException{

	public DoctorNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

}
