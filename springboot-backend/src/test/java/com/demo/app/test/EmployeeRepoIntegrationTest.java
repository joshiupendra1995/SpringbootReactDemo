package com.demo.app.test;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.demo.app.dto.EmployeeDto;
import com.demo.app.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepoIntegrationTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testVerifyEmailId() {

		String emailId = "joshiupendra34@gmail.com";
		String fullName = "upendra joshi";
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		assertEquals(emailId, employees.get(0).getEmailId());
		assertEquals(fullName, employees.get(0).getFirstName() + " " + employees.get(0).getLastName());

	}

}
