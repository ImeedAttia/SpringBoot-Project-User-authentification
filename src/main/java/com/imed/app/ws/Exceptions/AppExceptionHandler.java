package com.imed.app.ws.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.imed.app.ws.responses.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {
	
	
	

	@ExceptionHandler(value= {UserExceptions.class})
	public ResponseEntity<Object> HandlerUserExeption(UserExceptions ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	// on peut faire un autre ErrorMessge Class pour les autres object
	//@ExceptionHandler(value= {UserExceptions.class,ProductException.class,.........})
	@ExceptionHandler(value= Exception.class)
	public ResponseEntity<Object> HandlerOthersExeption(Exception ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
