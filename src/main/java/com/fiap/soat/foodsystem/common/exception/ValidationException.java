package com.fiap.soat.foodsystem.common.exception;

public class ValidationException extends DomainException {

	public ValidationException(String message) {
		super(message);
	}
	
	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
