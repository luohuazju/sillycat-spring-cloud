//package com.sillycat.mvclatency.repository;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.sillycat.mvclatency.domain.JobCountHistory;
//
//import lombok.extern.slf4j.Slf4j;
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
//		item1.setNewActiveCount(new Random().nextInt(10));
//		item1.setNewAdminCount(new Random().nextInt(100));
//		item1.setOldActiveCount(new Random().nextInt(10));
//		item1.setOldAdminCount(new Random().nextInt(100));
//		item1.setSourceID("9527");
//		item1.setRecordDate(new Date());
//		jobCountHistoryRepositoryCassandra.save(item1);
//
//		List<JobCountHistory> result = jobCountHistoryRepositoryCassandra.findBySourceID("9527");
//		Assert.assertNotNull(result);
//	}
//
//}
