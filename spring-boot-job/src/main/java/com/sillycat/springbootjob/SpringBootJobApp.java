package com.sillycat.springbootjob;

import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJobApp {
	
	@Autowired
	private JobScheduler jobScheduler;

	
	public static void main(String[] args) {
        SpringApplication.run(SpringBootJobApp.class, args);
    }

}
