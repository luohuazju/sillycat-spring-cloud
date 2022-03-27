//package com.sillycat.mvclatency.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sillycat.mvclatency.service.KafkaService;
//
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
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
//	public String sendToTopic(@PathVariable String topicName, @RequestBody String message) {
//		log.info("topicName " + topicName + " message " + message);
//		kafkaService.send(message);
//		return "Message sent";
//	}
//
//}
