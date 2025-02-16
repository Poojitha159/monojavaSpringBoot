package com.techlabs.app.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EmployeeExceptionHandler {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors()
	                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(EmployeeNotFoundException.class)
	    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
	        EmployeeErrorResponse error = new EmployeeErrorResponse();
	        error.setStatus(HttpStatus.NOT_FOUND.value());
	        error.setMessage(ex.getMessage());
	        error.setTimeStamp(LocalDateTime.now());

	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	        Map<String, String> errorDetails = new HashMap<>();
	        errorDetails.put("message", ex.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
	        System.out.println(ex.getClass().getSimpleName() + "Hello");
	        Map<String, String> errorDetails = new HashMap<>();
	        errorDetails.put("message", ex.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}