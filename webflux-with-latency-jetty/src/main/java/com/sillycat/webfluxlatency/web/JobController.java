package com.sillycat.webfluxlatency.web;

import java.time.LocalDateTime;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sillycat.webfluxlatency.services.JobService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Api(value = "/job/")
@RestController
public class JobController {

	@Autowired
	private JobScheduler jobScheduler;

	@Autowired
	private JobService jobService;

	@ApiOperation(value = "job", response = String.class)
	@GetMapping("/job/{msg}")
	public Mono<String> hello(@PathVariable String msg) {
		log.info("enter the controller with job message " + msg);
		jobScheduler.enqueue(() -> jobService.echo(msg)); // fire and forget
		jobScheduler.schedule(LocalDateTime.now().plusMinutes(5), () -> jobService.echo(msg));
		// after 5 minutes
		jobScheduler.scheduleRecurrently(Cron.every10minutes(), () -> jobService.echo(msg));
		// every 10 minutes
		return Mono.just("Welcome to reactive world " + msg);
	}

}
