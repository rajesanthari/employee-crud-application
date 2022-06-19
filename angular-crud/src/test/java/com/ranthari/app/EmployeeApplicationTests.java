
package com.ranthari.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranthari.app.model.Employee;
import com.ranthari.app.repository.EmployeeRepository;
import com.ranthari.app.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	EmployeeService employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	void verifyAllUsers() {
		when(employeeRepository.findAll()).thenReturn(
				Arrays.asList(new Employee(101L, "Rajesh", "Anthari", "rajesh@gmail.com", "9553630497", 1200),
						new Employee(102L, "Shiva", "Kumar", "shiva@gmail.com", "9848304697", 1400),
						new Employee(103L, "Pavindar", "B", "pavan@gmail.com", "9440094400", 1600)));

		assertEquals(3, employeeService.getAllEmployees().size());
	}

	@Test
	void verifyUser() {
		Employee employee = new Employee(101L, "Rajesh", "Anthari", "rajesh@gmail.com", "9553630497", 1200);
		when(employeeRepository.findById(101L)).thenReturn(Optional.of(employee));

		assertEquals(employee, employeeService.getAllEmployeeById(101L));
	}


	@Test
	void verifySaveUser() {
		Employee employee = new Employee(101L, "Rajesh", "Anthari", "rajesh@gmail.com", "9553630497", 1200);
		when(employeeRepository.save(employee)).thenReturn(employee);

		assertEquals(employee, employeeService.saveEmployee(employee));
	}

	@Test
	void verifyDeleteUser() {
		Employee employee = new Employee(101L, "Rajesh", "Anthari", "rajesh@gmail.com", "9553630497", 1200);
		when(employeeRepository.findById(101L)).thenReturn(Optional.of(employee));
		assertEquals(employee, employeeService.deleteEmployee(101L));
	}

}
