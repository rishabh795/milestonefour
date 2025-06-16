package com.core.milestonefour.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
						"timestamp", LocalDateTime.now(),
						"status", 404,
						"error", "not found",
						"message", e.getMessage()	
				));
	}
	
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<Map<String, Object>> handleInvalidDataException(InvalidDataException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
						"timestamp", LocalDateTime.now(),
						"status", 400,
						"error", "bad request",
						"message", e.getMessage()	
				));
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
