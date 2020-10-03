package com.demo.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.app.dto.EmployeeDto;
import com.demo.app.exception.BusinessException;
import com.demo.app.mapper.EmployeeMapper;
import com.demo.app.model.Employee;
import com.demo.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper empMapper;

	public List<EmployeeDto> getAllEmployees() {
		return empMapper.getDtoList(employeeRepository.findAll());
	}

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		return empMapper.getDto(employeeRepository.save(empMapper.getEO(employeeDto)));
	}

	public EmployeeDto getEmployeeById(Long id) {
		return empMapper.getDto(employeeRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Employee doesn't exist with id {}" + id)));

	}

	public EmployeeDto updateEmployee(EmployeeDto dto) {
		return empMapper.getDto(employeeRepository.save(empMapper.getEO(dto)));
	}

	public boolean deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Employee doesn't exist with id{}" + id));
		employeeRepository.delete(employee);
		return Boolean.TRUE;
	}

}
