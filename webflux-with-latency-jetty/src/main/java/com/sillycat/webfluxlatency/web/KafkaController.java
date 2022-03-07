//package com.sillycat.webfluxlatency.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sillycat.webfluxlatency.model.User;
//import com.sillycat.webfluxlatency.services.KafkaService;
//
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Mono;
//import reactor.kafka.sender.SenderResult;
//
//@Slf4j
//@Api(value = "/kafka/")
//@RestController
//public class KafkaController {
//
//	@Autowired
//	KafkaService kafkaService;
//
//	@PostMapping("/kafka/{topicName}")
//	public Mono<SenderResult<Integer>> sendToTopic(@PathVariable String topicName, @RequestBody String message) {
//		log.info("topicName " + topicName + " message " + message);
//		User user = User.newBuilder().setUserId("id1").setUserName(message).setAge(30).build();
//		return kafkaService.send(topicName, user);
//	}
//
//}
