package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Skill;
import com.example.demo.exceptions.SkillNotFoundException;
import com.example.demo.service.ISkillService;

@RestController
public class SkillController {
	
	@Autowired
	ISkillService skillServ;
	
	@PostMapping("/skill/add")
	ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
		System.out.println(skill);
		Skill newSkill = skillServ.addSkill(skill);
		System.out.println(newSkill);
		return new ResponseEntity<Skill>(newSkill,HttpStatus.CREATED);
	}
	
	@GetMapping("/skill/get/{skillId}")
	ResponseEntity<Skill> getSkillById(@PathVariable("skillId") int skillId) throws SkillNotFoundException {
		Skill newSkill = skillServ.getSkillById(skillId);
		return new ResponseEntity<Skill>(newSkill,HttpStatus.OK);
	}
	
	@GetMapping("/skill/findAll")
	ResponseEntity<List<Skill>> getAllSkills(){
		List<Skill> skillList = skillServ.getAllSkills();
		return new ResponseEntity<List<Skill>>(skillList,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/skill/delete/{skillId}")
	void removeSkill(@PathVariable int skillId) {
		skillServ.removeSkill(skillId);
	}

}
