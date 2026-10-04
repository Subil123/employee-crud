package employee_crud;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private  EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		
	this.employeeRepository =	employeeRepository;
	}
	
	
	
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	} 
	
	public List<Employee> getEmployeeDetails() 
	{
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeByID(long id) {
		
		
		
		//return employeeRepository.findById(id).orElse(null);
		
	return	employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
		
		
	}
	
	public Employee updateEmployeeByID(long id , Employee employee) {
		
			 
//		 Employee updateEmployee = employeeRepository.findById(id).orElse(null);
//		 
//		 if(updateEmployee == null) {
//				return null;
//			}else {
//		 
//		 updateEmployee.setName(employee.getName());
//		 updateEmployee.setEmail(employee.getEmail());
//		 updateEmployee.setSalary(employee.getSalary());
//		 
//		return employeeRepository.save(updateEmployee);
//			}
		
		
		Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()
				-> new EmployeeNotFoundException("Employee with ID " + id + " not Found"));
		
		updateEmployee.setName(employee.getName());
		updateEmployee.setEmail(employee.getEmail());
		updateEmployee.setSalary(employee.getSalary());
		
		return employeeRepository.save(updateEmployee);
		
		
		
		
		
		
		
	}
	
	public void deleteEmployeeByID(long id) {
		
		// employeeRepository.deleteById(id);
		
//		if(!employeeRepository.existsById(id)) {
//			return false;
//		}else {
//			
//			employeeRepository.deleteById(id);
//			return true;
//		}
		
		
		if(!employeeRepository.existsById(id)) {
			
			throw new EmployeeNotFoundException("Employee with ID " + id + " not Found");
		}
		employeeRepository.deleteById(id);
		
		
	}

}
