package com.apachekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic javaTopic() {

		return TopicBuilder.name("JavaTopic").build();
	}

	@Bean
	public NewTopic JsonJavaTopic() {

		return TopicBuilder.name("JsonJavaTopic").build();

	}

}
