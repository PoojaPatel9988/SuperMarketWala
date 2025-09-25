package com.example.seventh_project_super_market_wala.exception;

public record ErrorResponse(
		String timestamp,  //date and time
		int status,        //status code
		String error,      //Error:main
		String message,    //detailing of the error
		String path        //exact location of the error 
		) {	
}
