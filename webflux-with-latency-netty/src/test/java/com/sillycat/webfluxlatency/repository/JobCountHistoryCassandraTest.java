//package com.sillycat.webfluxlatency.repository;
//
//import java.util.Date;
//import java.util.Random;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.sillycat.webfluxlatency.domain.JobCountHistory;
//
//import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JobCountHistoryCassandraTest {
//
//	@Autowired
//	JobCountHistoryRepositoryCassandra jobCountHistoryRepositoryCassandra;
//
//	@Test
//	public void testBeanNotNull() {
//		log.info("init the bean jobCountHistoryRepositoryCassandra");
//		Assert.assertNotNull(jobCountHistoryRepositoryCassandra);
//	}
//
//	@Test
//	public void save() throws Exception {
//		JobCountHistory item1 = new JobCountHistory();
//		Date now = new Date();
//		item1.setNewActiveCount(new Random().nextInt(10));
//		item1.setNewAdminCount(new Random().nextInt(100));
//		item1.setOldActiveCount(new Random().nextInt(10));
//		item1.setOldAdminCount(new Random().nextInt(100));
//		item1.setSourceID("9527");
//		item1.setRecordDate(now);
//		item1.setRecordDate(new Date());
//		Mono<JobCountHistory> result1 = jobCountHistoryRepositoryCassandra.save(item1);
//		StepVerifier.create(result1).expectNext(item1).verifyComplete();
//
//		Flux<JobCountHistory> result2 = jobCountHistoryRepositoryCassandra.findBySourceIDNearTime("9527", now);
//		StepVerifier.create(result2).expectNextCount(1l).verifyComplete();
//
//	}
//
//}
