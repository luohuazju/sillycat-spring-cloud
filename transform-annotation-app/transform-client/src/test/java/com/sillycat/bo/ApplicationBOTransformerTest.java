package com.sillycat.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sillycat.pojo.ApplicationPOJO;

public class ApplicationBOTransformerTest {
	
	@Test
	public void dummy() {
		Assert.assertTrue("env is wrong", true);
	}
	
	@Test
	public void transform() {
		ApplicationBO bo = new ApplicationBO();
		bo.setId(Integer.valueOf(1));
		bo.setName("huatesting");
		List<EducationBO> list = new ArrayList<>();
		
		EducationBO bo1 = new EducationBO();
		bo1.setStartTime(new Date());
		bo1.setEndTime(new Date());
		bo1.setSchool("ZJU");
		bo1.setCourses(new ArrayList<>());
		
		list.add(bo1);
		
		bo.setEducations(list);
		
		ApplicationPOJO pojo = ApplicationBOTransformer.toApplicationPOJO(bo);
		Assert.assertNotNull(pojo);
		Assert.assertEquals(bo.getName(), pojo.getName());
	}

}
