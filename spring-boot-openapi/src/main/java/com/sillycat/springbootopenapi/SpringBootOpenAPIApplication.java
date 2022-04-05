package com.sillycat.springbootopenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootOpenAPIApplication {

	public static void main(String[] args) {
		log.info("SpringBootOpenAPIApplication init! ");
		SpringApplication.run(SpringBootOpenAPIApplication.class, args);
		log.info("SpringBootOpenAPIApplication started! ");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/v1/api-docs").allowedOrigins("*");
				registry.addMapping("/books/*").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "OPTIONS");
			}
		};
	}

}
