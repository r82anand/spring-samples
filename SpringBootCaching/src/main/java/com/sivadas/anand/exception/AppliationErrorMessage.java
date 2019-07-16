package com.sivadas.anand.exception;

import java.sql.Timestamp;

public class AppliationErrorMessage {

	private String message;
	private String details;
	private Timestamp time;

	public AppliationErrorMessage() {
	}

	public AppliationErrorMessage(String message, String details, Timestamp time) {
		super();
		this.message = message;
		this.details = details;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}
