package com.alethia.Exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CustomException handleCustomException(MethodArgumentNotValidException exp) {
		return new CustomException("Validation Failed :"+exp.getMessage());
	}
	
	@ExceptionHandler(CustomServiceException.class)
	public CustomException handleException(CustomServiceException exp) {
		return new CustomException(exp.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public CustomException handleException(Exception exp) {
		return new CustomException(exp.getMessage());
	}
}
