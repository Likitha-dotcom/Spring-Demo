package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String> {
	
	//Native Query
	//Displays login info of an emp whose ID we specify
	@Query(value="select * from login join employee on employee.emp_fogin_fk=login.email where employee.emp_id=:empId", nativeQuery=true)
	Login getLoginByEmpId(@Param("empId") int empId);
}
