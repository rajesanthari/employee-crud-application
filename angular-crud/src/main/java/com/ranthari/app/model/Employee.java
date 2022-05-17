package com.ranthari.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private Integer salary;

	public void setEmployee(Employee emp) {
		this.firstName = emp.firstName;
		this.lastName = emp.lastName;
		this.email = emp.email;
		this.mobile = emp.mobile;
		this.salary = emp.salary;
	}

	public Employee(String firstName, String lastName, String email, String mobile, Integer salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
	}

}
