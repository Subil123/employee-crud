package employee_crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<String> handleEmployeeNotFound(
//			EmployeeNotFoundException ex
//			){
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//	
//	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(404 , ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		
	}
	
	

}
