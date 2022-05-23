package com.ranthari.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ranthari.app.model.Employee;
import com.ranthari.app.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public Flux<Employee> getAllEmployees() {
		return empRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Mono<Employee> getAllEmployeeById(String id) {
		return empRepository.findById(id);
	}

	public Mono<Employee> saveEmployee(Employee emp) {
		return empRepository.save(emp);
	}

	public Mono<Employee> updateEmployee(String id, Employee emp) {
		
		return this.getAllEmployeeById(id).flatMap(empObj -> {
			empObj.setEmployee(emp);
			return empRepository.save(empObj);
		});
	}

	public Mono<Employee> deleteEmployee(String id) {
		Mono<Employee> employee = getAllEmployeeById(id);
		empRepository.deleteById(id);
		return employee;

	}

}
