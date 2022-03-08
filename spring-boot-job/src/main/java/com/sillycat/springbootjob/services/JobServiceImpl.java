package com.sillycat.springbootjob.services;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JobServiceImpl implements JobService{

	@Job(name = "EchoJob", retries = 1)
	public String echo(String message) {
		log.info("carl is calling this " + message);
		return "hello, " + message;
	}
	
	@Recurring(id = "JobID-EveryJob", cron = "*/2 * * * *")
	@Job(name= "EveryJob", retries = 1)
	public void everyMinumte() {
		log.info("carl is coding all the time");
	}
	
}
