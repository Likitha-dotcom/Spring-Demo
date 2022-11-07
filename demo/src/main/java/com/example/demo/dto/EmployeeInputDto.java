package com.example.demo.dto;

import lombok.Data;

@Data
public class EmployeeInputDto {
	private String firstName;
	private String email;
	private String password;
	private String role;
}
