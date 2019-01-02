package com.example.traveller.exception;

public abstract class RuntimeExceptionAbstract extends RuntimeException {

	protected final ErrorCode errorCode;

	public RuntimeExceptionAbstract(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
