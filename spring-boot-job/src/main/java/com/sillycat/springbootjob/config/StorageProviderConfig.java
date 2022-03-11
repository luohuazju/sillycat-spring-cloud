package com.sillycat.springbootjob.config;

import javax.sql.DataSource;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.StorageProviderUtils.DatabaseOptions;
import org.jobrunr.storage.sql.SqlStorageProvider;
import org.jobrunr.storage.sql.common.DefaultSqlStorageProvider;
import org.jobrunr.storage.sql.common.db.dialect.AnsiDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageProviderConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public StorageProvider storageProvider(JobMapper jobMapper) {
		// InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
		SqlStorageProvider storageProvider = new DefaultSqlStorageProvider(dataSource, new AnsiDialect(), "jobrunr_",
				DatabaseOptions.SKIP_CREATE);
		storageProvider.setJobMapper(jobMapper);
		return storageProvider;
	}

	@Bean
	public JobActivator jobActivator(ApplicationContext applicationContext) {
		return applicationContext::getBean;
	}

}
