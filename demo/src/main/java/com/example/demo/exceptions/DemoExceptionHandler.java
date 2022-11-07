package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.entity.ErrorResponse;

@ControllerAdvice //to handle exceptions globally
public class DemoExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception) {
		
		//create ErrorResponse obj
		ErrorResponse error = new ErrorResponse();
		
		//update ErrorResponse obj values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		//return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	//TO HANDLE SKILL NOT FOUND
	@ExceptionHandler(SkillNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(SkillNotFoundException exception) {
		
		//create ErrorResponse obj
		ErrorResponse error = new ErrorResponse();
		
		//update ErrorResponse obj values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		//return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	//TO HANDLE User(Email) NOT FOUND
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception) {
			
			//create ErrorResponse obj
			ErrorResponse error = new ErrorResponse();
			
			//update ErrorResponse obj values
			error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
			error.setMessage(exception.getMessage()); //get message from exception
			error.setTimeStamp(LocalDateTime.now()); // system time
			
			//return responseEntity obj
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
		}
		
		//TO handle Invalid Credentials
		@ExceptionHandler(InvalidCredentialsException.class)
		public ResponseEntity<ErrorResponse> handleException(InvalidCredentialsException exception) {
			
			//create ErrorResponse obj
			ErrorResponse error = new ErrorResponse();
			
			//update ErrorResponse obj values
			error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
			error.setMessage(exception.getMessage()); //get message from exception
			error.setTimeStamp(LocalDateTime.now()); // system time
			
			//return responseEntity obj
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
		}	
}
