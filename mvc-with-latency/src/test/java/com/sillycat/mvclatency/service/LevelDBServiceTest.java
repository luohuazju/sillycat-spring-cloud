package com.sillycat.mvclatency.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LevelDBServiceTest {

	@Autowired
	private LevelDBService levelDBService;

	@Test
	public void testNormalPutGetString() {
		String key = "key1";
		String value = "value1";
		levelDBService.put(key, value);

		String result = levelDBService.get(key, String.class);
		Assert.assertEquals(value, result);
		log.info("Output is " + result);
	}

}
