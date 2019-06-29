package com.sillycat.mvclatency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String payload) {
		log.info("sending payload='{}'", payload);
		kafkaTemplate.send("helloworld.mvc", payload);
	}

	@KafkaListener(topics = "helloworld.mvc")
	public void receive(String payload) {
		log.info("received payload='{}'", payload);
	}

}
