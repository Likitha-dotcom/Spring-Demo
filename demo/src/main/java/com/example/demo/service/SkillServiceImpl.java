package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Skill;
import com.example.demo.exceptions.SkillNotFoundException;
import com.example.demo.repository.ISkillRepository;

@Service
public class SkillServiceImpl implements ISkillService {
	
	@Autowired
	ISkillRepository skillRepo;
	
	@Override
	public Skill addSkill(Skill skill) {
		//add skills to DB
		return skillRepo.save(skill);
	}

	@Override
	public Skill getSkillById(int skillId) throws SkillNotFoundException {
		Optional<Skill> opt = skillRepo.findById(skillId);
		Skill skill = null;
		if(opt.isPresent()) {
			skill = opt.get();
		}else {
			throw new SkillNotFoundException("Skill not found with ID:"+skillId);
		}
		return skill;
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillRepo.findAll();
	}

	@Override
	public void removeSkill(int skillId) {
		Optional<Skill> opt = skillRepo.findById(skillId);
		if(opt.isPresent()) {
			skillRepo.deleteById(skillId);
		}
	}

}
