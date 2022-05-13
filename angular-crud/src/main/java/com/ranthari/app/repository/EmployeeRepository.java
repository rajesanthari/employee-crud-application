package com.ranthari.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranthari.app.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
