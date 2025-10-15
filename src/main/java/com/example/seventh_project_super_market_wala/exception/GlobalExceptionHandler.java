package com.example.seventh_project_super_market_wala.exception;

import java.time.Instant;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
//    @ExceptionHandler(NotFoundException.class)
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest req)
	{
		//using record
		ErrorResponse body= new ErrorResponse(
				Instant.now().toString(),
				HttpStatus.NOT_FOUND.value(),
				"category not found Exception",
				ex.getMessage(),
				req.getRequestURI()
				);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		
	}

}
