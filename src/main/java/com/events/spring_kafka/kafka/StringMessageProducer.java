package com.events.spring_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringMessageProducer {
    @Value("${spring.kafka.topic.name}")
    private String kafkaTopic1_string_messages;

    private static final Logger LOGGER = LoggerFactory.getLogger(StringMessageProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(kafkaTopic1_string_messages, message);
    }
}
