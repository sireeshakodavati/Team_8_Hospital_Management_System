package com.hexaware.hospitalmanagementsystem.exception;



/*
 * author:Madhuri&Sireesha,
 * lastmodified:19/11/23,
 * Description:Exception class for UsernameNotFoundException
 * 
*/

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class UsernameNotFoundException extends ResponseStatusException
{

	public UsernameNotFoundException(HttpStatusCode status, String reason, Throwable cause) {
		super(status, reason, cause);
		
	}

	/*
	 * public UsernameNotFoundException(HttpStatusCode status, String reason) {
	 * super(status, reason); }
	 */

	
}