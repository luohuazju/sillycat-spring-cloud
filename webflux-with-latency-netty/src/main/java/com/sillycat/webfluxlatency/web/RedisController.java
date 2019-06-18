package com.sillycat.webfluxlatency.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Api(value = "/redis/")
@RestController
public class RedisController {

	@ApiOperation(value = "Redis Get", response = String.class)
	@GetMapping("/redis/get/{key}")
	public Mono<String> get(@PathVariable String key) {
		Mono<String> response = reactiveRedisTemplateString.opsForValue().get(key);
		return response;
	}

	@ApiOperation(value = "Redis Set")
	@PostMapping(path = "/redis/set/{key}")
	public Mono<Boolean> set(@PathVariable String key, @RequestBody String request) {
		log.info("Set to Redis " + key + " = " + request);
		Mono<Boolean> response = reactiveRedisTemplateString.opsForValue().set(key, request);
		return response;
	}

	@Autowired
	ReactiveRedisTemplate<String, String> reactiveRedisTemplateString;

}
