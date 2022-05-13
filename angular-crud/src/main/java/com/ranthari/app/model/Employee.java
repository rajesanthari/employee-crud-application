package com.ranthari.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
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

}
