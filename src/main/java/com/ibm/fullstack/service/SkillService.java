package com.ibm.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ibm.fullstack.entity.Skill;
import com.ibm.fullstack.repository.SkillRepository;

@Service("skillService")
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;

	public void delete(Long skillId) {
		try {
			skillRepository.deleteById(skillId);
		} catch (EmptyResultDataAccessException e) {
			return;
		}
	}

	public List<Skill> findAll() {
		return skillRepository.findAll();
	}

	public Optional<Skill> findById(Long skillId) {
		return skillRepository.findById(skillId);
	}
	
	public List<Skill> findByName(String name) {
		return skillRepository.findByName(name);
	}

	public Skill save(Skill skill) {
		return skillRepository.save(skill);
	}

}
