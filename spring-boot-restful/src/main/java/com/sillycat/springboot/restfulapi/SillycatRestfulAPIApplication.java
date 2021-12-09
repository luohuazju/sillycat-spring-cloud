package com.sillycat.springboot.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.sillycat.springboot.restfulapi.akka.base.SpringExtension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SillycatRestfulAPIApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		log.info("NetsuiteConnectorApplication init! ");
		ConfigurableApplicationContext context = SpringApplication.run(SillycatRestfulAPIApplication.class);
		log.info("NetsuiteConnectorApplication started! ");
		log.info("Start to init the AKKA system...");
		SpringExtension ext = context.getBean(SpringExtension.class);
		ActorSystem system = context.getBean(ActorSystem.class);
		ActorRef supervisor = system.actorOf(ext.props("outOfBudgetSupervisor").withMailbox("akka.priority-mailbox"),
				"outOfBudgetSupervisor");
		log.info("supervisor init with path {}", supervisor.path());
		log.info("AKKA system success inited...");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SillycatRestfulAPIApplication.class);
	}

}
