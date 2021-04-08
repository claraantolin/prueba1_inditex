package com.inditex.exceptions;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException (NoSuchElementException exc) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return buildResponseEntity(status, exc);
	}
	
	private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus status, Exception exc) {
		ErrorResponse error = new ErrorResponse(exc.getMessage());
		error.setStatus(status.value());
		error.setTimestamp(new Date());
		return new ResponseEntity<>(error, status);
	}

}
