package com.apachekafka.consumerservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apachekafka.models.User;

@Service
public class JsonKafkaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumerService.class);

	@KafkaListener(topics = "JsonJavaTopic", groupId = "MyGroup")
	public void consume(User message) {

		LOGGER.info(String.format("Json Msg rcv........:  "+ message));

	}

}