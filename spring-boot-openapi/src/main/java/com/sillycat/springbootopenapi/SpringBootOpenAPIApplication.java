package com.sillycat.springbootopenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootOpenAPIApplication {

	public static void main(String[] args) {
		log.info("SpringBootOpenAPIApplication init! ");
		SpringApplication.run(SpringBootOpenAPIApplication.class, args);
		log.info("SpringBootOpenAPIApplication started! ");
	}

}
