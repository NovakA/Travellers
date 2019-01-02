package com.example.traveller.exception;

public class EmailExistsException extends RuntimeException {
	public EmailExistsException(String msg) {
		super(msg);
	}
}
