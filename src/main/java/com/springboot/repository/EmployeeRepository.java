package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	//all crud database methods
//	Employee findById(long id);
}
