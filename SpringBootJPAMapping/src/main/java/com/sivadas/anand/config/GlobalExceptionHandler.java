package com.sivadas.anand.config;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

import com.sivadas.anand.exception.AppliationErrorMessage;
import com.sivadas.anand.exception.ApplicationException;

@ControllerAdvice

public class GlobalExceptionHandler {

	@ExceptionHandler(ApplicationException.class)

	public ResponseEntity<?> resourceNotFoundException(ApplicationException ex, WebRequest request) {

		AppliationErrorMessage errorDetails = new AppliationErrorMessage(ex.getMessage(), request.getDescription(false),
				new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)

	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {

		AppliationErrorMessage errorDetails = new AppliationErrorMessage(ex.getMessage(), request.getDescription(false),
				new Timestamp(System.currentTimeMillis()));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}