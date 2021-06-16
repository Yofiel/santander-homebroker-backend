package com.pedrogobira.santanderhomebrokerbackend.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}

}
