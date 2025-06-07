package com.events.spring_kafka.kafka;

import com.events.spring_kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonObjectProducer {
    @Value("${spring.kafka.topic-json.name}")
    private String kafkaTopic1_json_objects;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonObjectProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonObjectProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic1_json_objects)
                .build();

        kafkaTemplate.send(message);
    }
}
