package com.sillycat.webfluxlatency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

	@Value("${basic.auth.username}")
	private String username;

	@Value("${basic.auth.password}")
	private String password;

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	private ExchangeFilterFunction basicAuthentication(String username, String password) {
		// String credentials = username + ":" + password;
		// String encodedCredentials =
		// java.util.Base64.getEncoder().encodeToString(credentials.getBytes());

		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			clientRequest.headers().setBasicAuth(username, password);
			return Mono.just(clientRequest);
		});
	}

	@Bean
	public WebClient webClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder.baseUrl("https://api.example.com").filter(basicAuthentication(username, password))
				.build();
	}

}
