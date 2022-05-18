package com.ranthari.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranthari.app.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeControllerTests {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	ObjectMapper objMapper = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		System.out.println(mockMvc);
	}

	@Test
	void verifySaveEmmployee() throws Exception {
		Employee employee = new Employee("Rajesh", "Anthari", "rajesh@gmail.com", "9553630497", 1200);
		String empString = objMapper.writeValueAsString(employee);
		MvcResult result = mockMvc
				.perform(post("/employee").content(empString).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Employee createdEmployee = objMapper.readValue(resultContent, Employee.class);
		System.out.println(resultContent);
		System.out.println(createdEmployee);
	}
	

	@Test
	void verifyAllEmmployee() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/employee").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		List<Employee> createdEmployee = objMapper.readValue(resultContent, List.class);
		System.out.println(resultContent);
		System.out.println(createdEmployee);
	}

}
