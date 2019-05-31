package com.sillycat.webfluxlatency.web;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class HelloController {

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

}
