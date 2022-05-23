package com.ranthari.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ranthari.app.model.Employee;
import com.ranthari.app.repository.EmployeeRepository;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		return empRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Employee getAllEmployeeById(String id) {
		return empRepository.findById(id).orElseThrow();
	}

	public Employee saveEmployee(Employee emp) {
		return empRepository.save(emp);
	}

	@Transactional
	public Employee updateEmployee(String id, Employee emp) {
		emp.setId(id);
		return empRepository.save(emp);
	}

	public Employee deleteEmployee(String id) {
		Employee employee = getAllEmployeeById(id);
		empRepository.delete(employee);
		return employee;
		
	}

}
