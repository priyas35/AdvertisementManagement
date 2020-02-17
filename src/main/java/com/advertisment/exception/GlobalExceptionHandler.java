package com.advertisment.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	
	/*
	 * @ExceptionHandler(AdminNotFoundException.class) public
	 * ResponseEntity<ErrorDto> adminNotFoundException(AdminNotFoundException e) {
	 * ErrorDto errorDto = new ErrorDto(); errorDto.setMessage(e.getMessage());
	 * errorDto.setStatusCode(HttpStatus.NOT_FOUND.value()); return
	 * ResponseEntity.status(HttpStatus.OK).body(errorDto); }
	 */
	
	
		

}
