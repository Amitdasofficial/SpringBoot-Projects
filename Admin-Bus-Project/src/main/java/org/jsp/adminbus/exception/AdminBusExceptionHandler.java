package org.jsp.adminbus.exception;

import org.jsp.adminbus.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdminBusExceptionHandler  extends ResponseEntityExceptionHandler{
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleAdminNFE(AdminNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData("Invalid Admin Id");
		return  new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	
	}

}
