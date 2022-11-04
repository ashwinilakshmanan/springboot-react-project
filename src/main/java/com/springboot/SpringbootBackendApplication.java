package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		Employee employee=new Employee();
//		employee.setFirstName("george");
//		employee.setLastName("pole");
//		employee.setEmail("john@gmail.com");
//		employeeRepository.save(employee);
//		
//		
//		Employee employee1=new Employee();
//		employee1.setFirstName("peter");
//		employee1.setLastName("pole");
//		employee1.setEmail("peter@gmail.com");
//		employeeRepository.save(employee);
	}
	
	

}
