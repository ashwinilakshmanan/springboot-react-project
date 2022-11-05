package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	
	// build create employee REST API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);	
	}
	
	//build get employee by id REST API
	@GetMapping("{id}")
	ResponseEntity<?> getEmployee(@PathVariable long id){
		Optional<Employee> employee=employeeRepository.findById(id);
		return employee.map(response->ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//build update employee REST API
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) throws ResourceNotFoundException 
			{
		Employee updateEmployee=employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id" +id));
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmail(employeeDetails.getEmail());
		
		employeeRepository.save(updateEmployee);
		
		return ResponseEntity.ok(updateEmployee);
	}
	
	//build delete employeeREST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) throws ResourceNotFoundException{
		
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));
		
		employeeRepository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
