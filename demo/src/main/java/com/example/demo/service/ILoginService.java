package com.example.demo.service;

import org.springframework.data.repository.query.Param;

import com.example.demo.dto.LoginOutputDto;
import com.example.demo.entity.Login;

public interface ILoginService {
	//abstract methods
	LoginOutputDto login(Login login);
	void logout(String email);
	Login resetPassword(String email,String newPassword);
	Login getLoginByEmpId(int empId);
}
