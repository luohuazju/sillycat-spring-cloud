package com.sillycat.webfluxlatency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WebFluxLatencyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		log.info("WebFluxLatencyApplication init! ");
		SpringApplication.run(WebFluxLatencyApplication.class);
		log.info("WebFluxLatencyApplication started! ");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebFluxLatencyApplication.class);
	}
}
