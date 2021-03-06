package com.demo.app.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.app.dto.EmployeeDto;
import com.demo.app.mapper.EmployeeMapper;
import com.demo.app.model.Employee;
import com.demo.app.repository.EmployeeRepository;
import com.demo.app.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private EmployeeMapper employeeMapper;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(employeeService);
	}

	@Test
	public void testVerifyEmailIdAndName() {

		String emailId = "joshiupendra34@gmail.com";
		String fullName = "upendra joshi";
		List<Employee> empList = Arrays.asList(new Employee(1, "upendra", "joshi", emailId));

		List<EmployeeDto> dtoList = Arrays.asList(new EmployeeDto(1, "upendra", "joshi", emailId));

		when(employeeRepository.findAll()).thenReturn(empList);

		when(employeeMapper.getDtoList(empList)).thenReturn(dtoList);
		List<EmployeeDto> employee = employeeService.getAllEmployees();
		assertEquals(emailId, employee.get(0).getEmailId());
		assertEquals(fullName, employee.get(0).getFirstName() + " " + employee.get(0).getLastName());

	}

	@Test
	public void testCreateEmployee() {
		Employee emp = new Employee(1, "xyz", "pqr", "xyz@gmail.com");
		Employee emp1 = new Employee(2, "xyz", "pqr", "xyz@gmail.com");

		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		empList.add(emp1);
		for (int i = 0; i < 2; i++) {
			employeeRepository.save(emp);
		}

		verify(employeeRepository, times(1)).save(emp);
	}
}
