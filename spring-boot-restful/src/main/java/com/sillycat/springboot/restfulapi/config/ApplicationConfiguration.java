package com.sillycat.springboot.restfulapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.sillycat.springboot.restfulapi.akka.base.SpringExtension;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;

@Configuration
@Lazy
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.sillycat.springboot.restfulapi.akka" })
public class ApplicationConfiguration {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SpringExtension springExtension;

	@Bean
	public ActorSystem actorSystem() {
		ActorSystem system = ActorSystem.create("JobsMonitorAPIAKKA", akkaConfiguration());
		springExtension.initialize(applicationContext);
		return system;
	}

	@Bean
	public Config akkaConfiguration() {
		return ConfigFactory.load();
	}

}
