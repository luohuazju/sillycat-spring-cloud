package com.sillycat.webfluxlatency.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@Api(value = "/vault/")
@RestController
public class VaultController {

	@Autowired
	VaultOperations vaultOperations;

	@ApiOperation(value = "get vault", response = String.class)
	@GetMapping("/vault/default")
	public Mono<String> getVault() {
		String response = vaultOperations.read("secret/springboot_application1").getData().toString();
		return Mono.just(response);

	}

}
