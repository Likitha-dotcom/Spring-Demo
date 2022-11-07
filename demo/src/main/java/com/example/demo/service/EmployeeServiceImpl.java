package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeInputDto;
import com.example.demo.dto.EmployeeOutputDtp;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repository.IEmployeeRepository;

@Service  //service impl class must have this annotation
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository empRepo ;

	@Override
	public Employee addEmployee(Employee emp) {
		// Add emp to DB
		return empRepo.save(emp);
	}

	@Override
	public Employee deleteEmployeeById(int empId) {
		//finds the emp by ID and if present proceed with delete
		Optional<Employee> opt = empRepo.findById(empId);
		Employee emp=null;
		if(opt.isPresent()) {
			//Read employee obj from Optional
			emp = opt.get();
			empRepo.deleteById(empId);
		}
		return emp;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Optional<Employee> opt = empRepo.findById(empId);
		Employee emp=null;
		if(opt.isPresent()) {
			//Read employee obj from Optional
			emp = opt.get();
		}else {
			throw new EmployeeNotFoundException("Emp not found with ID:"+empId);
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return empRepo.findByFirstName(name);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = empRepo.findAll();
		return empList;
	}

	@Override
	public Employee updateEmployee(int empId, Employee emp) {
		Optional<Employee> opt = empRepo.findById(empId);
		if(opt.isPresent()) {
			//update
			return empRepo.save(emp);
		}else {
			throw new EmployeeNotFoundException("Employee not found with ID:"+empId);
		}
		
	}

	@Override
	public Employee updateEmployeeName(int empId, String newName) {
		Optional<Employee> opt = empRepo.findById(empId);
		Employee updatedEmp=null;
		if(opt.isPresent()) {
			//Read employee obj from Optional
			Employee emp = opt.get();
			emp.setFirstName(newName);
			updatedEmp = empRepo.save(emp);
		}
		return updatedEmp;
	}

	@Override
	public EmployeeOutputDtp addEmployee(EmployeeInputDto empDto) {
		
		System.out.println("------------------");
		System.out.println("Before Conversion");
		System.err.println(empDto);
		System.out.println("------------------");
		
		//convert DTO to emp
		//create emp obj
		Employee emp = new Employee();
		emp.setFirstName(empDto.getFirstName());
		
		//create login obj
		Login login = new Login();
		login.setEmail(empDto.getEmail());
		login.setPassword(empDto.getPassword());
		login.setRole(empDto.getRole());
		emp.setLogin(login);
		
		System.out.println("------------------");
		System.out.println("After Conversion");
		System.err.println(emp);
		System.out.println("------------------");
		
		Employee newEmp = empRepo.save(emp);
		
		//convert newEmp to DTO
		EmployeeOutputDtp empOutputDto = new EmployeeOutputDtp();
		empOutputDto.setEmpId(newEmp.getEmpId());
		empOutputDto.setFirstName(newEmp.getFirstName());
		empOutputDto.setEmail(newEmp.getLogin().getEmail());
		empOutputDto.setRole(newEmp.getLogin().getRole());
		
		return empOutputDto;
	}

	@Override
	public Employee addEmpAddr(int empId, List<Address> addrList) {
		Optional<Employee> opt = empRepo.findById(empId);
		Employee emp;
		if(opt.isPresent()) {
			emp = opt.get();
			List<Address> getAddr = emp.getAddress();
			getAddr.addAll(addrList);
			empRepo.save(emp);
		}
		return null;
	}

}
