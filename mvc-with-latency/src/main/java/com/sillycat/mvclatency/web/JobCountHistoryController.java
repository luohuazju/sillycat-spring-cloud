//package com.sillycat.mvclatency.web;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sillycat.mvclatency.domain.JobCountHistory;
//import com.sillycat.mvclatency.repository.JobCountHistoryRepositoryCassandra;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@Api(value = "/jobcounthistory/")
//@RestController
//public class JobCountHistoryController {
//
//	@ApiOperation(value = "fetch job by sourceID", response = String.class)
//	@GetMapping("/jobcounthistory/{sourceID}")
//	public List<JobCountHistory> findBySourceID(@PathVariable String sourceID) {
//		List<JobCountHistory> results = jobCountHistoryRepositoryCassandra.findBySourceID(sourceID);
//		return results;
//	}
//
//	@Autowired
//	JobCountHistoryRepositoryCassandra jobCountHistoryRepositoryCassandra;
//
//}
