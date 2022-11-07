package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginOutputDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.InvalidCredentialsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	ILoginRepository loginRepo;
	
	@Override
	public LoginOutputDto login(Login login) {
		Optional<Login> Loginopt = loginRepo.findById(login.getEmail());
		
		if(Loginopt.isPresent()) {
			Login log = Loginopt.get();
			if (log.getPassword().equals(login.getPassword())
					&& log.getRole().equals(login.getRole())) {
				
				// convert log to LoginOutputDto Object
				LoginOutputDto resDto = new LoginOutputDto();
				resDto.setEmail(login.getEmail());
				resDto.setRole(login.getRole());
				return resDto;
				
			}else {
				throw new InvalidCredentialsException("Invalid credentials!");
			}
		}else {
			// throw exception if given email not present in the db.
			throw new UserNotFoundException("User not found with email: "+login.getEmail());
		}

	}

	
	@Override
	public void logout(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public Login resetPassword(String email, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Login getLoginByEmpId(int empId) {
		//Displays login info of an emp whose ID we specify
		//refers the method we created in ILoginRepository
		return loginRepo.getLoginByEmpId(empId);
	}

}
