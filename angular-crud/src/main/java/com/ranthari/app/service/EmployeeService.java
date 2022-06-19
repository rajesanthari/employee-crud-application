package com.ranthari.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ranthari.app.model.Employee;
import com.ranthari.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		return empRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Employee getAllEmployeeById(Long id) {
		return empRepository.findById(id).orElseThrow();
	}

	public Employee saveEmployee(Employee emp) {
		return empRepository.save(emp);
	}

	public Employee updateEmployee(Long id, Employee emp) {
		emp.setId(id);
		return empRepository.save(emp);
	}

	public Employee deleteEmployee(Long id) {
		Employee employee = getAllEmployeeById(id);
		empRepository.delete(employee);
		return employee;
		
	}

}
