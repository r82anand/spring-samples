/*
 * File name		: Greeting.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 19-Feb-2020
 * Reviewed by		:
 *
 */
package com.sivadas.anand.dto;

import java.io.Serializable;

/**
 * The Class Greeting.
 */
public class Greeting implements Serializable{

	private static final long serialVersionUID = 4191353399798039405L;
	private Long counter;
	private String message;

	/**
	 * Instantiates a new greeting.
	 *
	 * @param counter the counter
	 * @param message the message
	 */
	public Greeting(final Long counter, final String message) {
		super();
		this.counter = counter;
		this.message = message;
	}

	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public Long getCounter() {
		return counter;
	}

	/**
	 * Sets the counter.
	 *
	 * @param counter the new counter
	 */
	public void setCounter(final Long counter) {
		this.counter = counter;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (counter == null ? 0 : counter.hashCode());
		result = prime * result + (message == null ? 0 : message.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Greeting other = (Greeting) obj;
		if (counter == null) {
			if (other.counter != null) {
				return false;
			}
		} else if (!counter.equals(other.counter)) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Greeting [counter=" + counter + ", message=" + message + "]";
	}

}
