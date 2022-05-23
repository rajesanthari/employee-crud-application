package com.ranthari.app.controller;

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

import com.ranthari.app.model.Employee;
import com.ranthari.app.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping
	public Flux<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Mono<Employee> getAllEmployeeById(@PathVariable String id) {
		return empService.getAllEmployeeById(id);
	}

	@PostMapping
	public Mono<Employee> saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}

	@PutMapping("/{id}")
	public Mono<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee emp) {
		return empService.updateEmployee(id, emp);
	}

	@DeleteMapping("/{id}")
	public Mono<Employee> deleteEmployee(@PathVariable String id) {
		return empService.deleteEmployee(id);
	}

}
