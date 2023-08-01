package com.sillycat.webfluxlatency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.sillycat.webfluxlatency.services.JobServiceImpl;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class WebClientConfig {

	@Value("${consul.host}")
	private String consulHost;

	@Value("${consul.auth.username}")
	private String username;

	@Value("${consul.auth.password}")
	private String password;

	
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}


	@Bean
	public WebClient webClient(WebClient.Builder webClientBuilder) {
		log.info("consul username = " + username + " password = " + password);
		return webClientBuilder.baseUrl(consulHost)
				.defaultHeaders(headers -> headers.setBasicAuth(username, password))
				.build();
	}

}
