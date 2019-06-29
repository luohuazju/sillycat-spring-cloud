//package com.sillycat.mvclatency.repository;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTemplateTest {
//
//	@Autowired
//	RedisTemplate<String, String> redisTemplateString;
//
//	@Test
//	public void testBeanNotNull() {
//		log.info("init the bean redisTemplateString");
//		Assert.assertNotNull(redisTemplateString);
//	}
//	
//	@Test
//	public void testStringCRUD() {
//		String key = "language";
//		String value = "java";
//		this.redisTemplateString.opsForValue().set(key, value);
//		String result1 = redisTemplateString.opsForValue().get(key);
//		Assert.assertEquals(result1, value);
//		this.redisTemplateString.delete(key);
//		String result2 = redisTemplateString.opsForValue().get(key);
//		Assert.assertNull(result2);
//	}
//
//}
