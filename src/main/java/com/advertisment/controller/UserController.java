package com.advertisment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	/*
	 * @Autowired
	 * 
	 *//**
		 * 
		 * @author PriyaDharshini S.
		 * @since 2020-02-11. This method will authenticate the employee.
		 * @param loginDto - details of the employee login
		 * @return LoginResponseDto which has status message,statusCode and employee
		 *         details
		 * @throws EmployeeNotFoundException it will throw the exception if the employee
		 *                                   is not there.
		 * 
		 *//*
			 * @PostMapping("/login") public ResponseEntity<LoginResponseDto>
			 * authenticateEmployee(@Valid @RequestBody LoginRequestDto loginRequestDto)
			 * throws EmployeeNotFoundException { LoginResponseDto loginResponseDto =
			 * employeeService.authenticateEmployee(loginRequestDto); log.
			 * info("Entering into EmployeeController authenticateEmployee method: calling employeeService"
			 * );
			 * loginResponseDto.setMessage(ApplicationConstants.AUTHENTICATION_SUCCESSFUL);
			 * loginResponseDto.setStatusCode(HttpStatus.OK.value()); return new
			 * ResponseEntity<>(loginResponseDto, HttpStatus.OK); }
			 */

}
