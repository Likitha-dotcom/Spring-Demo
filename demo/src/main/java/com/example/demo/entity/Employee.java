package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data	//adds constructor, getters setters and toString
//@AllArgsConstructor //create constructor with arguments
//@NoArgsConstructor	//create constructors with no arguments
//@Getter	//to add getter methods only
//@Setter	//to add setter methods only
@ToString //to add to string to print the obj
public class Employee {
	
	@Id	//	make ID as primary key
	@GeneratedValue //to generate IDs automatically
	private int empId;
//	@Getter	//adds getter for only first name 
//	@Setter //adds setters for only first name
	private String firstName;
	private String lastName;
	
	//one to one relationship 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_fogin_fk")
	private Login login;
	
	//one to many relationship 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_addr_fk")
	private List<Address> address;
	
	//many to many relationship
//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
//    @JoinTable(
//        name = "employee_skills", 
//        joinColumns = { @JoinColumn(name = "emp_id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "skill_id") }
//    )
//	private List<Skill> skill;
	
}
