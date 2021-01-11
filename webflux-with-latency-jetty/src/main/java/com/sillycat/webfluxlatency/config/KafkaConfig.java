package com.sillycat.webfluxlatency.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sillycat.webfluxlatency.model.User;
import com.sillycat.webfluxlatency.serializer.AvroSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

@Slf4j
@Setter
@Getter
@Configuration
@EnableConfigurationProperties
public class KafkaConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupID;

	@Bean
	public KafkaSender<String, User> kafkaProducer() {
		final Map<String, Object> producerProps = new HashMap<>();
		producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);
		producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		final SenderOptions<String, User> producerOptions = SenderOptions.create(producerProps);
		return KafkaSender.create(producerOptions);
	}

//	@Bean
//	public KafkaReceiver<String, User> kafkaReceiver() {
//		final Map<String, Object> consumerProps = new HashMap<>();
//		consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);
//		consumerProps.put(ConsumerConfig.CLIENT_ID_CONFIG, "webflux-1");
//		consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupID);
//		consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//
//		ReceiverOptions<String, User> consumerOptions = ReceiverOptions.<String, User>create(consumerProps)
//				.subscription(Collections.singleton("sillycat"))
//				.addAssignListener(partitions -> log.debug("onPartitionsAssigned {}", partitions))
//				.addRevokeListener(partitions -> log.debug("onPartitionsRevoked {}", partitions))
//				.withValueDeserializer(new AvroDeserializer<>(User.class));
//
//		return KafkaReceiver.create(consumerOptions);
//	}

}
