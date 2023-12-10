package com.hexaware.hospitalmanagementsystem.exception;
/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:exception class for medicaltest
 * 
 */

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class MedicalTestNotFoundException extends ResponseStatusException {

	public MedicalTestNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

}