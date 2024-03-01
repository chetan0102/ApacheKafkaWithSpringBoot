package com.apachekafka.producerservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.apachekafka.models.User;

@Service
public class JsonKafkaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducerService.class);

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducerService(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {

		LOGGER.info(String.format("Json Message sent :" + data.toString()));

		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "JsonJavaTopic").build();


		kafkaTemplate.send(message);
	}

}