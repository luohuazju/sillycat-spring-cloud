//package com.sillycat.webfluxlatency.repository;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.ReactiveRedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTemplateTest {
//
//	@Autowired
//	ReactiveRedisTemplate<String, String> reactiveRedisTemplateString;
//
//	@Test
//	public void testBeanNotNull() {
//		log.info("init the bean reactiveRedisTemplate");
//		Assert.assertNotNull(reactiveRedisTemplateString);
//	}
//
//	@Test
//	public void testStringCRUD() {
//		String key = "language";
//		String value = "java";
//		Mono<Boolean> result1 = this.reactiveRedisTemplateString.opsForValue().set(key, value);
//		StepVerifier.create(result1).expectNext(true).verifyComplete();
//		
//		Mono<String> result2 = reactiveRedisTemplateString.opsForValue().get(key);
//		StepVerifier.create(result2).expectNext(value).verifyComplete();
//		
//		Mono<Long> result3 = reactiveRedisTemplateString.delete(key);
//		StepVerifier.create(result3).expectNext(1l).verifyComplete();
//		
//		Mono<String> result4 = reactiveRedisTemplateString.opsForValue().get(key);
//		StepVerifier.create(result4).expectNext().verifyComplete();
//	}
//
//}
