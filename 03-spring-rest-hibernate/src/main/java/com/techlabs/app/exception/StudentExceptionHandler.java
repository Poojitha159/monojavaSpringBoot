package com.techlabs.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
	
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now());

	    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
	
		System.out.println( "Exception Handler");
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now());

	    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
}
