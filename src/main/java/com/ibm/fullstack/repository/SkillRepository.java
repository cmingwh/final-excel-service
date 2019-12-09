package com.ibm.fullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	List<Skill> findByName(String name);

}