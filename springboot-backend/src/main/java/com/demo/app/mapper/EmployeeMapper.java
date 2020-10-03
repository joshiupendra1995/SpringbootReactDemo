package com.demo.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.app.dto.EmployeeDto;
import com.demo.app.model.Employee;

@Component
public class EmployeeMapper {

	public Employee getEO(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmailId());

	}

	public EmployeeDto getDto(Employee emp) {
		return new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId());
	}

	public List<Employee> getEOList(List<EmployeeDto> dtoList) {
		List<Employee> empList = new ArrayList<>();
		dtoList.forEach(dto -> {
			Employee emp = new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmailId());
			empList.add(emp);
		});
		return empList;
	}

	public List<EmployeeDto> getDtoList(List<Employee> empList) {
		List<EmployeeDto> dtoList = new ArrayList<>();
		empList.forEach(emp -> {
			EmployeeDto dto = new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId());
			dtoList.add(dto);
		});
		return dtoList;
	}

}
