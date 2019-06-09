package com.sillycat.webfluxlatency.repository;

import java.util.Date;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.sillycat.webfluxlatency.domain.JobCountHistory;

import reactor.core.publisher.Flux;

@Repository
public interface JobCountHistoryRepositoryCassandra extends ReactiveCassandraRepository<JobCountHistory, String>{

	@Query("select * from jobcounthistory where source_id=?0")
	public Flux<JobCountHistory> findBySourceID(String sourceID);
	
	@Query("select * from jobcounthistory where source_id=?0 and record_date>=?1")
	public Flux<JobCountHistory> findBySourceIDNearTime(String sourceID, Date recordDate);
	
}
