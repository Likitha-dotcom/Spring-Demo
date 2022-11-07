package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeOutputDtp;
import com.example.demo.dto.LoginOutputDto;
import com.example.demo.entity.Login;
import com.example.demo.service.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	ILoginService loginservice;
	
	//search user based on email ID
	@PostMapping("/login/dto")
	ResponseEntity<LoginOutputDto> login(@RequestBody Login login) {
		LoginOutputDto user = loginservice.login(login);
		return new ResponseEntity<LoginOutputDto>(user,HttpStatus.OK);
	}
	
	@GetMapping("/logout/{email}")
	public void logout(@PathVariable("email") String email) {
		
	}
	
	@PostMapping("/reset/{email}")
	public Login resetPassword(@PathVariable("email") String email,@RequestBody String newPassword) {
		return null;
	}
	
	//Displays login info of an emp whose ID we specify
	@GetMapping("/login/getLogin/byEmpId/{empId}")
	ResponseEntity<Login> getLoginByEmpId(@PathVariable("empId") int empId) {
		Login login = loginservice.getLoginByEmpId(empId);
		return new ResponseEntity<>(login,HttpStatus.OK);
		
	}
}
