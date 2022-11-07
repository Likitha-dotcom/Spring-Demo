package com.example.demo.service;

import com.example.demo.dto.EmployeeInputDto;
import com.example.demo.dto.EmployeeOutputDtp;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;

import java.util.*;

public interface IEmployeeService {
	// abstract methods
		Employee addEmployee(Employee emp); //done
		Employee deleteEmployeeById(int empId); //done
		Employee getEmployeeById(int empId); //done
		List<Employee> getEmployeeByName(String name); //done
		List<Employee> getAllEmployees(); //done
		Employee updateEmployee(int empId, Employee emp); //done
		Employee updateEmployeeName(int empId, String newName); //done
		EmployeeOutputDtp addEmployee(EmployeeInputDto empDto); //done
		Employee addEmpAddr(int empId,List<Address> addrList);
}
