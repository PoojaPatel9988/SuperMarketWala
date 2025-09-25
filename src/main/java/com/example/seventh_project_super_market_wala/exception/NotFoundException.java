package com.example.seventh_project_super_market_wala.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	//constructor
    //TODO auto-generated constructor stub
	public NotFoundException(String message) {
		super(message);
	}
	

}
