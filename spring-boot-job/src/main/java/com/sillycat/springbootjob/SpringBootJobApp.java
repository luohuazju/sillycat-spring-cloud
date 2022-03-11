package com.sillycat.springbootjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootJobApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJobApp.class, args);
	}

}
