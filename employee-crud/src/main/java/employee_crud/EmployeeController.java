package employee_crud;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;



@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	private EmployeeService employeeservice;
	
	public EmployeeController(EmployeeService employeeservice) {
		
		this.employeeservice = employeeservice;
		
	}
	
//	@PostMapping
//	public Employee createEmployee ( @RequestBody Employee employee) {
//		
//		return employeeservice.createEmployee(employee);
//		
//	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee (@Valid @RequestBody Employee employee) {
		
		Employee createEmployee = employeeservice.createEmployee(employee);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createEmployee);
		
	}
	
	@GetMapping
	public List<Employee> getEmployeeDetails(){
		
		return employeeservice.getEmployeeDetails();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id) {
		
		 // 1 --------- return employeeservice.getEmployeeByID(id);
		
//  2 --------     Employee employee = employeeservice.getEmployeeByID(id);
//		 
//		 if(employee == null) {
//			 return ResponseEntity.notFound().build();
//		 }
//		 return ResponseEntity.ok(employee);


		Employee employee = employeeservice.getEmployeeByID(id);
		
		 return ResponseEntity.ok(employee);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeByID(@PathVariable long id , @RequestBody Employee employee) 
	{
		//return employeeservice.updateEmployeeByID(id, employee);
		
//	Employee updateEmployee	= employeeservice.updateEmployeeByID(id, employee);
//	
//	if(updateEmployee == null) {
//		return ResponseEntity.notFound().build();
//	}else {
//		return ResponseEntity.ok(updateEmployee);
//	}
		
		Employee updateEmployee = employeeservice.updateEmployeeByID(id, employee);
		
		return ResponseEntity.ok(updateEmployee);
		
	}
	
	@DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteEmployeeByID(@PathVariable long id) {
		
		// employeeservice.deleteEmployeeByID(id);
		
//		  Boolean deleted = employeeservice.deleteEmployeeByID(id);
//		  
//		  if(!deleted) {
//			  
//			  return ResponseEntity.notFound().build();
//		  }else {
//			  return ResponseEntity.noContent().build();
//		  }
		
//		employeeservice.deleteEmployeeByID(id);
//		return ResponseEntity.noContent().build();
		
		ApiResponse apiResponse = new ApiResponse(200, "Employee deleted Successfully");
		
		employeeservice.deleteEmployeeByID(id);
		
		return ResponseEntity.ok(apiResponse);
		
		
	}
}
