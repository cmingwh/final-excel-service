package com.ibm.fullstack.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fullstack.entity.Skill;
import com.ibm.fullstack.feign.SkillApi;

@RestController
@RequestMapping("/feign")
public class FeignController {
	@Autowired
	private SkillApi skillApi;
 
	@GetMapping(value = "/skill/{id}")
	public Optional<Skill> findById(@PathVariable("id") Long id) {
	    return skillApi.findById(id);
	}
}