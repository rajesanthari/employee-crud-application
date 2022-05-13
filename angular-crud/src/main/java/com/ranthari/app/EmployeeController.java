package com.ranthari.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranthari.app.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeRepository empRepository;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return empRepository.getAllEmployees();
	}
	@GetMapping("/{id}")
	public Employee getAllEmployeeById(@PathVariable Long id) {
		return empRepository.getAllEmployeeById(id);
	}
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empRepository.saveEmployee(emp);
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		return empRepository.updateEmployee(id, emp);
	}
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable Long id) {
		return empRepository.deleteEmployee(id);
	}
	
	//update
	//delete
	
}
