package com.events.spring_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfigurations {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Bean
    public NewTopic kafkaTopic1_string_messages(){
        return TopicBuilder.name(topicName)
                .build();
    }

    @Bean
    public NewTopic kafkaTopic1_json_objects(){
        return TopicBuilder.name(topicJsonName)
                .build();
    }
}
