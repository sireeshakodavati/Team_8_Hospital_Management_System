package com.hexaware.hospitalmanagementsystem.exception;

/*
 * author:Madhuri&Sireesha,
 * lastmodified:14/11/23,
 * Description:Global exception handler class
 * 
 */

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ch.qos.logback.classic.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus()
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleAnyExp(Exception e) {
		Logger logger = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);
		logger.info(" i am global exception handler");
		return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
	}

}