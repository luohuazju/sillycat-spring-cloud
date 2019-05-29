package com.sillycat.mvclatency.web;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/hello/")
@RestController
public class HelloController {

	@ApiOperation(value = "hello latency", response = String.class)
	@GetMapping("/hello/{latency}")
	public String hello(@PathVariable long latency) {
		try {
			TimeUnit.MILLISECONDS.sleep(latency); // 1
		} catch (InterruptedException e) {
			return "Error during thread sleep";
		}
		return "Welcome to reactive world with latency " + latency ;
	}

}
