package com.techlabs.app.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;
	
	
	
}