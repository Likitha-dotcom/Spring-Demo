package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	//if JpaRepository is not providing requested methods create your own methods here
	List<Employee> findByFirstName(String name);
}
