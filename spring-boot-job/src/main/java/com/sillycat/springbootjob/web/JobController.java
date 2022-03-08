package com.sillycat.springbootjob.web;

import java.time.LocalDateTime;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sillycat.springbootjob.services.JobService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobScheduler jobScheduler;

	@Autowired
	private JobService jobService;

	@GetMapping(value = "/enqueue/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> enqueue(@PathVariable("input") @DefaultValue("default") String input) {
		jobScheduler.enqueue(() -> jobService.echo(input)); //fire and forget
		String scheduleInput = input + " after 5 minutes";
		LocalDateTime min1 = LocalDateTime.now().plusMinutes(1);
		log.info(min1.toString());
		jobScheduler.schedule(min1, () -> jobService.echo(scheduleInput));
		// after 5 minutes
		String everyInput = input + " every 10 minutes";
		jobScheduler.scheduleRecurrently("JobId-" + input,Cron.every5minutes(), () -> jobService.echo(everyInput));
		// every 10 minutes
		return okResponse("job enqueued successfully");
	}

	private ResponseEntity<String> okResponse(String feedback) {
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}

}
