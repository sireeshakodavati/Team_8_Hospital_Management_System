package com.hexaware.hospitalmanagementsystem.exception;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:17/11/23,
 * Description:exception class for appointment
 * 
 */

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class AppointmentValidationException extends ResponseStatusException {

	public AppointmentValidationException(HttpStatusCode status, String reason) {
		super(status, reason);
	}

}
