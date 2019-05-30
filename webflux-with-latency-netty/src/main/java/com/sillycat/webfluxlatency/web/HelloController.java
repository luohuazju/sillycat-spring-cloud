package com.sillycat.webfluxlatency.web;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@Api(value = "/hello/")
@RestController
public class HelloController {

	@ApiOperation(value = "hello latency", response = String.class)
	@GetMapping("/hello/{latency}")
	public Mono<String> hello(@PathVariable int latency) {
		return Mono.just("Welcome to reactive world " + latency).delayElement(Duration.ofMillis(latency));
	}

}
