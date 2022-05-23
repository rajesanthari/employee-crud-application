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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
@CrossOrigin
@Api(tags = "employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping
	@ApiOperation(value = "List Employees", notes = "List all the employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employees found"),
			@ApiResponse(code = 200, message = "Employees not found") })
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find employee", notes = "Find employee By id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee found"),
			@ApiResponse(code = 200, message = "Employee not found") })
	public Employee getAllEmployeeById(@PathVariable Long id) {
		return empService.getAllEmployeeById(id);
	}

	@PostMapping
	@ApiOperation(value = "Create Employee", notes = "It permits to create a new employee")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Employee created successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })

	public Employee saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update employee", notes = "It permits to update a employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "employee update successfully"),
			@ApiResponse(code = 404, message = "employee not found"),
			@ApiResponse(code = 400, message = "Invalid request") })

	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		return empService.updateEmployee(id, emp);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove Employee", notes = "It permits to remove a employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee removedsuccessfully"),
			@ApiResponse(code = 404, message = "Employee not found") })
	public Employee deleteEmployee(@PathVariable Long id) {
		return empService.deleteEmployee(id);
	}

}
