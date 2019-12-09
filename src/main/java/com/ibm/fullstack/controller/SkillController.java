package com.ibm.fullstack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fullstack.entity.Skill;
import com.ibm.fullstack.service.SkillService;

@RestController
@CrossOrigin
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        skillService.delete(id);
        return true;
    }
    
    @GetMapping(value = "/find/{id}")
    public Optional<Skill> findById(@PathVariable("id") Long id) {
        return skillService.findById(id);
    }
    
    @PostMapping(value = "/")
    public Skill save(@RequestBody Skill skill) {
        return skillService.save(skill);
    }
    
    @GetMapping(value = "/findAll")
    public List<Skill> findAll() {
        return skillService.findAll();
    }
}