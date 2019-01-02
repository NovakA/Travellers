package com.example.traveller.dto;

import com.example.traveller.exception.ErrorCode;
import com.example.traveller.exception.RuntimeExceptionAbstract;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("Error")
public class ErrorDto {

	private Integer code;
	private String message;
	private String detail;

	@JsonCreator
	public ErrorDto(@JsonProperty("code") Integer code,
					@JsonProperty("message") String message,
					@JsonProperty("detail") String detail) {
		this.code = code;
		this.message = message;
		this.detail = detail;
	}

	public ErrorDto(ErrorCode code, String detail) {
		this.code = code.getCode();
		this.message = code.getMessage();
		this.detail = detail;
	}

	public ErrorDto(RuntimeExceptionAbstract exceptionAbstract) {
		this(exceptionAbstract.getErrorCode().getCode(), exceptionAbstract.getMessage(), null);
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDetail() {
		return detail;
	}
}
