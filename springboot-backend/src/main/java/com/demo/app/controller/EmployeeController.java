package com.demo.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.app.dto.EmployeeDto;
import com.demo.app.service.EmployeeService;

/**
 * @author Upendra
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// get all employees
	/**
	 * @return employees
	 */
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// create employee rest api
	/**
	 * @param employee
	 * @return Employee
	 */
	@PostMapping("/employees")
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
	}

	// get employee by id rest api
	/**
	 * @param id
	 * @return Employee
	 */
	@GetMapping("/employees/{id}")
	public EmployeeDto getEmployeeById(@PathVariable Long id) {

		return employeeService.getEmployeeById(id);
	}

	// update employee rest api

	/**
	 * @param id
	 * @param employeeDetails
	 * @return Employee
	 */
	@PutMapping("/employees")
	public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {

		return employeeService.updateEmployee(employeeDto);
	}

	// delete employee rest api
	/**
	 * @param id
	 * @return map
	 */
	@DeleteMapping("/employees/{id}")
	public boolean deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return Boolean.TRUE;
	}

}
