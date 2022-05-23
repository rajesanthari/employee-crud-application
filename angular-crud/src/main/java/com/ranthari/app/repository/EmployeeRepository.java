package com.ranthari.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ranthari.app.model.Employee;


public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	
}
