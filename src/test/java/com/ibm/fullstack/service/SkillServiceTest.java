package com.ibm.fullstack.service;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.fullstack.entity.Skill;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillServiceTest {
	@Autowired
	private SkillService skillService;

	Long testId = 0L;
	
	@Test
	public void saveTest() {
		Long skillId = new Long(90000L);
		Skill skill = new Skill();
		skill.setName("test1234567890");
		skill.setSkillId(skillId);
		skill.setPrerequeistes("test");
		skill.setToc("toc");
		Skill newSkilll = skillService.save(skill);
		testId = newSkilll.getSkillId();
		
	}
	
	@Test
	public void findByNameTest() {
		List<Skill> result = skillService.findByName("test1234567890");
		if(result.size()>0) {
			Iterator<Skill> it = result.iterator();
			while(it.hasNext()) {
				Skill skill = it.next();
				skillService.delete(skill.getSkillId());
			}
			assertTrue(true);
		}
	}
	
	@Test
	public void findByIdTest() {
		Optional<Skill> result = skillService.findById(testId);
		assertTrue(!result.isPresent());
		
	}
	
	@Test
	public void findAllTest() {
		List<Skill> skills = skillService.findAll();
		assertTrue(skills.size()>0);
	}
	
	@Test
	public void deleteTest() {
		skillService.delete(testId);
		assertTrue(true);
	}

}
