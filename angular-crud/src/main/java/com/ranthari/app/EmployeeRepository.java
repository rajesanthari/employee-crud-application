package com.ranthari.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ranthari.app.model.Employee;

@Repository
public class EmployeeRepository {
	
	Long lastEmp = 100L;
	List<Employee> employees = new ArrayList<>();
	
	{
		if (employees.size() == 0) {
			employees.add(new Employee(++lastEmp, "Rajesh", "Anthari", "rajeshanthari@gmail.com", "9553630497", 10000));
			employees.add(new Employee(++lastEmp, "Naresh", "s", "nareshs@gmail.com", "9553630498", 20000));
		}
	}
	
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	public Employee getAllEmployeeById(Long id) {
		
		Employee employee = employees.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);
		if (employee == null ) {
			throw new RuntimeException("No Employee found with id: " + id);
		}
		return employee;
	}

	public Employee saveEmployee(Employee emp) {
		emp.setId(++lastEmp);
		employees.add(emp);
		return emp;
	}
	public Employee updateEmployee(Long id, Employee emp) {
		Employee existingEmp = getAllEmployeeById(id);
		existingEmp.setEmployee(emp);
		return existingEmp;
	}
	public Employee deleteEmployee(Long id) {
		Employee existingEmp = getAllEmployeeById(id);
		employees.remove(existingEmp);
		return existingEmp;
	}
	
}
