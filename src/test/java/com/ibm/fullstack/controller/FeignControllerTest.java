package com.ibm.fullstack.controller;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.ibm.fullstack.entity.Skill;
import com.ibm.fullstack.feign.SkillApi;

@SpringBootTest
public class FeignControllerTest {
	@InjectMocks
    private FeignController feignController;
	
//	@InjectMocks
	@Autowired
    private SkillApi skillApi;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        skillApi = Mockito.mock(SkillApi.class);
		ReflectionTestUtils.setField(feignController, "skillApi", skillApi);
    }
	
	@Test
    public void testFeignController() {
		
		Skill skill = new Skill();
		skill.setName("test1");
		skill.setSkillId(11L);
		Optional<Skill> mockData = Optional.ofNullable(skill);
		Mockito.when(skillApi.findById(Mockito.anyLong())).thenReturn(mockData);
		
        Optional<Skill> result = feignController.findById(12L);
        assertTrue(result.isPresent());
    }
}  
