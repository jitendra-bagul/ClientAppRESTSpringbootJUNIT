package com.exazeit.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MobileNotFound.class)
	public ResponseEntity<?> handleMobilenotFoundException (MobileNotFound e, WebRequest r){
		
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), r.getDescription(false));
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	
	}
	
	

	@ExceptionHandler(FirstNameNotFound.class)
	public ResponseEntity<?> handleFirstNameNotFoundException (FirstNameNotFound e, WebRequest r){
		
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), r.getDescription(false));
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	
	}
	
	

	@ExceptionHandler(IDNotFound.class)
	public ResponseEntity<?> handleIDNumNotFoundException (IDNotFound e, WebRequest r){
		
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), r.getDescription(false));
	    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	
	}
	
	
	
	
}
