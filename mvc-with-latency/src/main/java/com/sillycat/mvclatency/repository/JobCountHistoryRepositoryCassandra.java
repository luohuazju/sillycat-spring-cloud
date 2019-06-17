//package com.sillycat.mvclatency.repository;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.sillycat.mvclatency.domain.JobCountHistory;
//
//@Repository
//public interface JobCountHistoryRepositoryCassandra extends CrudRepository<JobCountHistory, String> {
//
//	@Query("select * from jobcounthistory where source_id=?0")
//	public List<JobCountHistory> findBySourceID(String sourceID);
//
//	@Query("select * from jobcounthistory where source_id=?0 and record_date>?1")
//	public List<JobCountHistory> findBySourceIDNearTime(String sourceID, Date recordDate);
//
//	@Query("delete from jobcounthistory where source_id=?0")
//	public void deleteBySourceID(String sourceID);
//
//}
