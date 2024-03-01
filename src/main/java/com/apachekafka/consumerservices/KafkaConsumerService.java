package com.apachekafka.consumerservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "JavaTopic", groupId = "MyGroup")
	public void consume(String message) {

		LOGGER.info(String.format("Msg rcv........:  "+ message));

	}

}