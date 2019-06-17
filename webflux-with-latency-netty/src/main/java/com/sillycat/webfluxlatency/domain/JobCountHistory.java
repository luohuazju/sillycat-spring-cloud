//package com.sillycat.webfluxlatency.domain;
//
//import java.util.Date;
//
//import org.springframework.data.cassandra.core.cql.Ordering;
//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@Getter
//@ToString
//@Table("jobcounthistory")
//public class JobCountHistory {
//
//	@PrimaryKeyColumn(name = "source_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
//	private String sourceID;
//
//	@PrimaryKeyColumn(name = "record_date", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
//	private Date recordDate;
//
//	@Column("new_active_count")
//	private Integer newActiveCount;
//
//	@Column("new_admin_count")
//	private Integer newAdminCount;
//
//	@Column("old_active_count")
//	private Integer oldActiveCount;
//
//	@Column("old_admin_count")
//	private Integer oldAdminCount;
//
//}
