package com.sillycat.webfluxlatency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WebFluxLatencyApplication {

	public static void main(String[] args) throws Exception {
		log.info("WebFluxLatencyApplication init! ");
		SpringApplication.run(WebFluxLatencyApplication.class);
		log.info("WebFluxLatencyApplication started! ");
	}

}
