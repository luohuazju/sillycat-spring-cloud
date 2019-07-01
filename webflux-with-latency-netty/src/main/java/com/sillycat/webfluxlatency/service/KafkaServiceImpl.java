package com.sillycat.webfluxlatency.service;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import reactor.kafka.sender.SenderResult;

@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {

	@Autowired
	KafkaSender<Integer, String> kafkaSender;

	@Autowired
	KafkaReceiver<Object, Object> kafkaReceiver;

	@PostConstruct
    public void init(){
		((Flux<ReceiverRecord<Object, Object>>) kafkaReceiver.receive()).doOnNext(r -> {
			processEvent(r.value().toString());
			r.receiverOffset().acknowledge();
		}).subscribeOn(Schedulers.elastic());
    }

	private void processEvent(String message) {
		log.info("received message:" + message);
	}

	public Mono<SenderResult<Integer>> send(final String payload) {
		log.info("send out message:" + payload);
		SenderRecord<Integer, String, Integer> message = SenderRecord
				.create(new ProducerRecord<>("hello-webflux", payload), 1);
		return kafkaSender.send(Mono.just(message)).next();
	}

}
