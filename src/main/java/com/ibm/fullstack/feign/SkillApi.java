package com.ibm.fullstack.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.fullstack.entity.Skill;

@FeignClient(name = "skill")
public interface SkillApi {
	@GetMapping(value = "/skill/find/{id}")
	Optional<Skill> findById(@PathVariable("id") Long id);

}
