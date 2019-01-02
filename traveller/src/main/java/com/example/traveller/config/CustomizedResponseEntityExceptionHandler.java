package com.example.traveller.config;

import com.example.traveller.dto.ErrorDto;
import com.example.traveller.exception.ErrorCode;
import com.example.traveller.exception.RuntimeExceptionAbstract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto> handleException(Exception ex) {
		if (ex instanceof RuntimeExceptionAbstract) {
			return handleExceptionAbstract(RuntimeExceptionAbstract.class.cast(ex));
		} else {
			return handleGeneric(ex);
		}
	}

	private ResponseEntity<ErrorDto> handleExceptionAbstract(RuntimeExceptionAbstract e) {
		ErrorDto errorDto = new ErrorDto(e);
		return new ResponseEntity<>(errorDto, e.getErrorCode().getHttpStatus());
	}

	private ResponseEntity<ErrorDto> handleGeneric(Throwable e) {
		ErrorDto errorDto = new ErrorDto(ErrorCode.UNKNOWN, e.getMessage());
		return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
