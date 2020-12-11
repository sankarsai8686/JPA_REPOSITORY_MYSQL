package com.sankar.tech.exception;

import java.util.Date;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler implements ErrorController{

	public final static String ERROR_PATH = "/error";
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@GetMapping(ERROR_PATH)
	public String handleError()
	{
		return "Not found :-> Check URL";
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(
			ResourceNotFoundException exception, WebRequest request)
	{
		System.out.println("==handleResourceNotFoundException==");
		CustomError customError = new CustomError(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(customError,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(ResourceNotFoundException exception, WebRequest request)
	{
		System.out.println("===handleException===");
		CustomError customError = new CustomError(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(customError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
