package com.fiap.soat.foodsystem.domain.exception;

import com.fiap.soat.foodsystem.common.exception.DomainException;

public class NotFoundException extends DomainException {

	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
