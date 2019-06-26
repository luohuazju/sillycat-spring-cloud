//package com.sillycat.mvclatency.config;
//
//import java.util.List;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Setter
//@Getter
//@Configuration
//@EnableConfigurationProperties
//@ConfigurationProperties("spring.redis.cluster")
//public class RedisClusterConfig {
//	
//	/*
//     * spring.redis.cluster.nodes[0] = 127.0.0.1:7379
//     * spring.redis.cluster.nodes[1] = 127.0.0.1:7380
//     * ...
//     */
//    List<String> nodes;
//    
//	@Bean
//    public RedisConnectionFactory clusterConnectionFactory() {
//        return new JedisConnectionFactory(
//            new RedisClusterConfiguration(this.getNodes()));
//    }
//
//}
