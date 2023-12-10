package com.hexaware.hospitalmanagementsystem.exception;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:17/11/23,
 * Description:exception class for patient
 * 
 */

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PatientIdNotFoundException extends ResponseStatusException {
	
	public PatientIdNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

}
