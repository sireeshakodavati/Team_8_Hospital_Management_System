package com.hexaware.hospitalmanagementsystem.exception;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:exception class for admin
 * 
 */

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class AdminNotFoundException extends ResponseStatusException {

	public AdminNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

}