package com.sillycat.webfluxlatency.services;

import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderResult;

public interface KafkaService {
	
	public Mono<SenderResult<Integer>> send(final String topicName, final String payload);

}
