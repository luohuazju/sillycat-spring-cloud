package com.sillycat.webfluxlatency.services;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sillycat.webfluxlatency.model.User;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import reactor.kafka.sender.SenderResult;

@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {

	@Autowired
	KafkaSender<String, User> kafkaSender;

	@Autowired
	KafkaReceiver<String, User> kafkaReceiver;

	@PostConstruct
	public void init() {
		((Flux<ReceiverRecord<String, User>>) kafkaReceiver.receive()).doOnNext(r -> {
			processEvent(r.value());
			r.receiverOffset().acknowledge();
		}).subscribe();
	}

	private void processEvent(User user) {
		log.info("received message:" + user.toString());
	}

	public Mono<SenderResult<Integer>> send(final String topicName, User user) {
		log.info("send out message:" + user.toString());
		SenderRecord<String, User, Integer> message = 
				SenderRecord.create(new ProducerRecord<>(topicName, user), 1);
		return kafkaSender.send(Mono.just(message)).next();
	}

}
