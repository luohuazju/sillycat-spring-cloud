package com.sillycat.webfluxlatency.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@Api(value = "/config/")
@RestController
public class ConfigController {

	@Autowired
	private WebClient webClient;
	
	@ApiOperation(value = "get config", response = String.class)
	@GetMapping("/config/default")
    public Mono<String> getExternalData() {
        return webClient.get()
                .uri("/data")
                .retrieve()
                .bodyToMono(String.class);
    }
}
