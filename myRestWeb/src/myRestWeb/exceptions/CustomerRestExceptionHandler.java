package myRestWeb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomerRestExceptionHandler {
	

	
@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e)
	{
	    CustomerErrorResponse errorResponse = new CustomerErrorResponse();
		
		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e)
	{
		CustomerErrorResponse errorResponse= new CustomerErrorResponse();
		
		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
