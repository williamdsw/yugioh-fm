package com.yugioh.fm.controllers.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yugioh.fm.services.exception.ObjectNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> handleObjectNotFoundException(ObjectNotFoundException exception,
			HttpServletRequest request) {
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestamp(System.currentTimeMillis());
		error.setStatus(notFound.value());
		error.setError("Not found!");
		error.setMessage(exception.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(notFound).body(error);
	}

}
