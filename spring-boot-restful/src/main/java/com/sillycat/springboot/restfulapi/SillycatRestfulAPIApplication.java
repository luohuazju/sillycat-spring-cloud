package com.sillycat.springboot.restfulapi;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableJpaAuditing
public class SillycatRestfulAPIApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		log.info("NetsuiteConnectorApplication init! ");
		ConfigurableApplicationContext context = SpringApplication.run(SillycatRestfulAPIApplication.class);
		log.info("NetsuiteConnectorApplication started! ");
		log.info("Start to init the AKKA system...");
		// SpringExtension ext = context.getBean(SpringExtension.class);
		// ActorSystem system = context.getBean(ActorSystem.class);
		// ActorRef supervisor =
		// system.actorOf(ext.props("outOfBudgetSupervisor").withMailbox("akka.priority-mailbox"),
		// "outOfBudgetSupervisor");
		// log.info("supervisor init with path {}", supervisor.path());
		log.info("AKKA system success inited...");
		
		try {
		    String serverAddr = "centos7-master";
			String dataId = "springboot.restfulapi";
			String group = "DEFAULT_GROUP";
			Properties properties = new Properties();
			properties.put("serverAddr", serverAddr);
			properties.put("username","nacos");
	        properties.put("password","kaishi117A");
			ConfigService configService = NacosFactory.createConfigService(properties);
			String content = configService.getConfig(dataId, group, 5000);
			log.info("get the nacos configuration-------------------------");
			System.out.println(content);
			log.info("----------------------------------------------------");
		} catch (NacosException e) {
		    e.printStackTrace();
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SillycatRestfulAPIApplication.class);
	}

}
