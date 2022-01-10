package com.sillycat.pojo;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.sillycat.bo.EducationBO;

public class EducationPOJOTransformerTest {
	
	@Test
	public void dummy() {
		Assert.assertTrue("env is wrong", true);
	}
	
	@Test
	public void transform() { 
		EducationPOJO pojo = new EducationPOJO();
		pojo.setCourses(new ArrayList<>());
		pojo.setEndTime(new Date());
		pojo.setSchool("ZJU");
		pojo.setStartTime(new Date());
		
		EducationBO bo = EducationPOJOTransformer.toEducationBO(pojo);
		Assert.assertNotNull(bo);
		Assert.assertEquals(bo.getSchool(), pojo.getSchool());
	}

}
