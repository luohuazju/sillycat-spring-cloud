//package com.sillycat.webfluxlatency.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sillycat.webfluxlatency.domain.JobCountHistory;
//import com.sillycat.webfluxlatency.repository.JobCountHistoryRepositoryCassandra;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import reactor.core.publisher.Flux;
//
//@Api(value = "/jobcounthistory/")
//@RestController
//public class JobCountHistoryController {
//
//	@ApiOperation(value = "fetch job by sourceID", response = JobCountHistory.class)
//	@GetMapping("/jobcounthistory/{sourceID}")
//	public Flux<JobCountHistory> findBySourceID(@PathVariable String sourceID) {
//		Flux<JobCountHistory> results = jobCountHistoryRepositoryCassandra.findBySourceID(sourceID);
//		return results;
//	}
//
//	
//	@Autowired
//	JobCountHistoryRepositoryCassandra jobCountHistoryRepositoryCassandra;
//
//}
