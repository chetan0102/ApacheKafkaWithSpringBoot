package com.apachekafka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apachekafka.models.User;
import com.apachekafka.producerservices.JsonKafkaProducerService;

@RestController
public class JsonMessageController {

	private JsonKafkaProducerService jsonKafkaProducerService;

	public JsonMessageController(JsonKafkaProducerService jsonKafkaProducerService) {
		this.jsonKafkaProducerService = jsonKafkaProducerService;
	}

	@PostMapping("/publish/json")
	public ResponseEntity<String> publish(@RequestBody User data) {

		jsonKafkaProducerService.sendMessage(data);

		return ResponseEntity.ok("Json Msg sent to the topic");
	}
}
