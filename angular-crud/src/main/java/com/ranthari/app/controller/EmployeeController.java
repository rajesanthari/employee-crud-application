package com.ranthari.app.controller;

import java.util.List;

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

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getAllEmployeeById(@PathVariable Long id) {
		return empService.getAllEmployeeById(id);
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		return empService.updateEmployee(id, emp);
	}

	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable Long id) {
		return empService.deleteEmployee(id);
	}

}
