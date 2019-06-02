package com.sillycat.webfluxlatency.web;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Api(value = "/hello/")
@RestController
public class HelloController {

	@ApiOperation(value = "hello latency", response = String.class)
	@GetMapping("/hello/{latency}")
	public Mono<String> hello(@PathVariable int latency) {
		return Mono.just("Welcome to reactive world " + latency).delayElement(Duration.ofMillis(latency));
	}

	@GetMapping("/go/{latency}")
	public Mono<String> go(@PathVariable int latency) {
		Mono<String> mono = Mono.fromCallable(() -> {
			try {
				Thread.sleep(latency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return String.format("processing nonblocking %s", latency);
		});
		return mono.subscribeOn(Schedulers.elastic());
	}

	@GetMapping("/slow/{latency}")
	public Mono<String> slow(@PathVariable int latency) {
		try {
			Thread.sleep(latency);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Mono.just("Welcome to reactive world " + latency);
	}

}
