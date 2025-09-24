package com.example.seventh_project_super_market_wala.exception;

public record ErrorResponse(
		String timestamp,
		int status,
		String error,
		String message,
		String path
		) {

	
}
