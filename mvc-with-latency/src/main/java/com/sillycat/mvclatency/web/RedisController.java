package com.sillycat.mvclatency.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "/redis/")
@RestController
public class RedisController {

	@ApiOperation(value = "Redis Get", response = String.class)
	@GetMapping("/redis/get/{key}")
	public String get(@PathVariable String key) {
		String response = redisTemplateString.opsForValue().get(key);
		return "Fetch from Redis " + response;
	}

	@ApiOperation(value = "Redis Set")
	@PostMapping(path = "/redis/set/{key}")
	public void set(@PathVariable String key, @RequestBody String request) {
		log.info("Set to Redis " + key + " = " + request);
		redisTemplateString.opsForValue().set(key, request);
	}

	@Autowired
	RedisTemplate<String, String> redisTemplateString;

}
