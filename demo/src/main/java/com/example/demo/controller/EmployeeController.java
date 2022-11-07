package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeInputDto;
import com.example.demo.dto.EmployeeOutputDtp;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;

@RestController //to denote controller
public class EmployeeController {
	
	@Autowired
	IEmployeeService empServ;
	
	//for posting/sending data to database 
	@PostMapping("/employee/add")
	//returns the newEmp obj as response along with that return response code
	ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		Employee newEmp = empServ.addEmployee(emp);
		System.out.println(newEmp);
		return new ResponseEntity<>(newEmp,HttpStatus.CREATED); // status code 201
	}
	
	//DTO add method
	@PostMapping("/employee/add/dto")
	//this will take only necessary input from user and doesn't take info like salary etc
	//will take only those inputs defined in Emp input DTO and adds to DB
	ResponseEntity<EmployeeOutputDtp> addEmployee(@RequestBody EmployeeInputDto emp) {
		System.out.println(emp);
		EmployeeOutputDtp newEmp = empServ.addEmployee(emp);
		System.out.println(newEmp);
		return new ResponseEntity<EmployeeOutputDtp>(newEmp,HttpStatus.CREATED); // status code 201
	}
	
    //for getting data from database empId in @GetMapping is replaced by id sent
	@GetMapping("/employee/get/{empId}")
	ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
		Employee newEmp = empServ.getEmployeeById(empId);
		return new ResponseEntity<>(newEmp,HttpStatus.OK); // status 200
	}
	
	//Delete emp by ID
	@DeleteMapping("/employee/delete/{empId}")
	ResponseEntity<Employee> deleteEmployeeById(@PathVariable int empId) {
		Employee newEmp = empServ.deleteEmployeeById(empId);
		return new ResponseEntity<>(newEmp,HttpStatus.OK); // status 200
	}
	
	//update emp by ID
	@PutMapping("/employee/update/{empId}")
	ResponseEntity<Employee> updateEmployee(@PathVariable int empId,@RequestBody Employee emp) {
		Employee newEmp = empServ.updateEmployee(empId,emp);
		return new ResponseEntity<>(newEmp,HttpStatus.OK); // status 200
	}
	
	//update emp by name
	@PatchMapping("/employee/update/firstName/{name}/empId/{id}")
	ResponseEntity<Employee> updateEmployeeName(@PathVariable("id") int empId,@PathVariable("name") String newName) {
		Employee newEmp = empServ.updateEmployeeName(empId,newName);
		return new ResponseEntity<>(newEmp,HttpStatus.OK); // status 200
	}
	
	//get all employees 
	@GetMapping("/employee/findAll")
	ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> empList = empServ.getAllEmployees();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK); // status 200
	}
	
	//get employees by fname
		@GetMapping("/employee/findByName/{firstName}")
		ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("firstName") String name) {
			List<Employee> empList = empServ.getEmployeeByName(name);
			return new ResponseEntity<>(empList,HttpStatus.OK); // status 200
		}
		
	//add address to an emp without address
	@PostMapping("/employee/add/{empId}")
	ResponseEntity<Employee> addEmpAddr(@PathVariable("empId") int empId,@RequestBody List<Address> addrList) {
		Employee newEmp = empServ.addEmpAddr(empId, addrList);
		return new ResponseEntity<>(newEmp,HttpStatus.OK);
	}
}
