package com.sillycat.springbootjob.web;

import org.jobrunr.scheduling.JobScheduler;
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
		return okResponse("job enqueued successfully");
	}

	private ResponseEntity<String> okResponse(String feedback) {
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}

}
