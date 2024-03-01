package com.apachekafka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafka.producerservices.KafkaProducerService;

@RestController
public class MessageController {

	private KafkaProducerService kafkaProducerServices;

	public MessageController(KafkaProducerService kafkaProducerServices) {
		this.kafkaProducerServices = kafkaProducerServices;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {

		kafkaProducerServices.sendMessage(message);

		return ResponseEntity.ok("Msg sent to the topic");
	}
}
