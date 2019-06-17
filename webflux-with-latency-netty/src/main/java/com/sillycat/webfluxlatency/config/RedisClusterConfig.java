package com.sillycat.webfluxlatency.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("spring.redis.cluster")
public class RedisClusterConfig {

	/*
	 * spring.redis.cluster.nodes[0] = 127.0.0.1:7379 
	 * spring.redis.cluster.nodes[1] = 127.0.0.1:7380 ...
	 */
	List<String> nodes;

	@Bean
	public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
		return new LettuceConnectionFactory(new RedisClusterConfiguration(this.getNodes()));
	}

	@Bean
	public ReactiveRedisTemplate<String, String> reactiveRedisTemplateString(
			ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
		return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, RedisSerializationContext.string());
	}

}
