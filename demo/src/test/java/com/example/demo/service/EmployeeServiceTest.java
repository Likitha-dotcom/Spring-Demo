package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.EmployeeInputDto;
import com.example.demo.dto.EmployeeOutputDtp;
import com.example.demo.entity.Employee;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	IEmployeeService empServ;
	
	@Test
	void getEmployeeByIdTest() {
		Employee emp = empServ.getEmployeeById(9);
		assertEquals("Ankit", emp.getFirstName());
	}
	
	@Test
	void getAllEmployeesTest() {
		List<Employee> empList = empServ.getAllEmployees();
		int totalEmps = empList.size();
		assertEquals(3, totalEmps);
		Employee emp = empList.get(0);
		assertEquals("Likitha", emp.getFirstName());
		assertEquals("S", emp.getLastName());
	}
	
	@Disabled //method wont be executed
	@Test
	void deleteEmployeeByIdTest() {
		Employee emp =empServ.deleteEmployeeById(22);
		assertEquals(21, emp.getEmpId());
		assertEquals("Ramesh", emp.getFirstName());
		assertEquals("Singh", emp.getLastName());
	}
	
	@Disabled
	@Test
	void addEmployeeTest() {
		EmployeeInputDto dto = new EmployeeInputDto();
		dto.setFirstName("Keerti");
		dto.setEmail("keerti@gmail.com");
		dto.setPassword("keerti@123");
		dto.setRole("Employee");
		
		EmployeeOutputDtp outputDto = empServ.addEmployee(dto);
		
		assertEquals("Keerti", outputDto.getFirstName());
		assertEquals("keerti@gmail.com", outputDto.getEmail());
		assertEquals("Employee", outputDto.getRole());
	}
	
	
	
}
