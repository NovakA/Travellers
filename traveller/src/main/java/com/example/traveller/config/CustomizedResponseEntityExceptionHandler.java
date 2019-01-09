package com.example.traveller.config;

import com.example.traveller.dto.ErrorDto;
import com.example.traveller.exception.ErrorCode;
import com.example.traveller.exception.RuntimeExceptionAbstract;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto> handleException(Exception ex) {
		if (ex instanceof RuntimeExceptionAbstract) {
			return handleExceptionAbstract((RuntimeExceptionAbstract) ex);
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

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers, HttpStatus status, WebRequest request) {
		final String detail = createDetail(ex);
		ErrorDto errorDetails = new ErrorDto(ErrorCode.INVALID_REQUEST, detail);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	private String createDetail(MethodArgumentNotValidException exception) {
		StringBuilder stringBuilder = new StringBuilder();
		final List<ObjectError> objectErrorList = exception.getBindingResult().getAllErrors();
		final ObjectError lastObjectError = objectErrorList.get(objectErrorList.size() - 1);

		for (ObjectError objectError : objectErrorList) {
			if (objectError instanceof FieldError) {
				stringBuilder.append(((FieldError) objectError).getField());
				stringBuilder.append(", ");
			}

			stringBuilder.append(objectError.getDefaultMessage());

			if (!lastObjectError.equals(objectError)) {
				stringBuilder.append("\\n");
			}
		}
		return stringBuilder.toString();
	}
}
