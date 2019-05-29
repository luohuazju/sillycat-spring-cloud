package com.sillycat.mvclatency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MvcLatencyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		log.info("MvcLatencyApplication init! ");
		SpringApplication.run(MvcLatencyApplication.class);
		log.info("MvcLatencyApplication started! ");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MvcLatencyApplication.class);
	}
}
