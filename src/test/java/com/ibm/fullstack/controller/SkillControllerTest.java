package com.ibm.fullstack.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.ibm.fullstack.entity.Skill;
import com.ibm.fullstack.service.SkillService;

@SpringBootTest
public class SkillControllerTest {
	@InjectMocks
    private SkillController skillController;
	
	@InjectMocks
    private SkillService skillService;
	
//	@InjectMocks
//    private SkillRepository skillRepository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        skillService = Mockito.mock(SkillService.class);
		ReflectionTestUtils.setField(skillController, "skillService", skillService);
    }
	
	@Test
    public void findAllTest() {
		List<Skill> mockData = new ArrayList<Skill>();
		Skill skill = new Skill();
		skill.setName("test1");
		skill.setSkillId(11L);
		mockData.add(skill);
		Skill skill2 = new Skill();
		skill2.setName("test2");
		skill2.setSkillId(22L);
		mockData.add(skill2);
		Mockito.when(skillService.findAll()).thenReturn(mockData);
		
        List<Skill> result = skillController.findAll();
        assertTrue(result.size()>0);
    }
	
	@Test
    public void deleteTest() {
        skillController.delete(90000L);
        assertTrue(true);
    }
	
	@Test
    public void findByIdTest() {
		Skill skill = new Skill();
		skill.setName("test1");
		skill.setToc("test");
		skill.setPrerequeistes("test");
		skill.setSkillId(11L);
		Optional<Skill> mockData = Optional.ofNullable(skill);
		Mockito.when(skillService.findById(90000L)).thenReturn(mockData);
		
        Optional<Skill> result = skillController.findById(90000L);
        assertTrue(result.isPresent());
    }
	
	@Test
    public void saveTest() {
		Skill skill = new Skill();
		skill.setName("test1");
		skill.setSkillId(90000L);
        skillController.save(skill);
        assertTrue(true);
    }
	
}  
