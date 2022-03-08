package com.sillycat.springbootjob.services;

import org.jobrunr.jobs.annotations.Job;
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
	
}
