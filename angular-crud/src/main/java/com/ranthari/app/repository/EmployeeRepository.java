package com.ranthari.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ranthari.app.model.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
}
