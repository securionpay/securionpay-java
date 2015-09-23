package com.securionpay.exception;

public class SignException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SignException(Throwable throwable) {
		super(throwable);
	}
}
