package com.example.traveller.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	// 1000+ Common errors
	UNKNOWN(1000, HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error happened."),
	INTERNAL_ERROR(1001, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error."),
	INVALID_INPUT_BODY(1002, HttpStatus.BAD_REQUEST, "Input cannot be parsed correctly."),
	INVALID_REQUEST(1003, HttpStatus.BAD_REQUEST, "Input contains illegal values."),
	INVALID_AUTHENTICATION(1004, HttpStatus.UNAUTHORIZED, "Invalid authentication"),
	/**/;

	private static final String MESSAGE_FORMAT = "Error (%s %d): %s";
	private final int code;
	private final HttpStatus httpStatus;
	private final String message;

	ErrorCode(final int code, final HttpStatus httpStatus, final String message) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return String.format(MESSAGE_FORMAT, httpStatus, code, message);
	}
}
