package com.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByFirstNameAndLastName(String firstName,String lastName);
	
	Employee findByEmailId(String emailId);

}
