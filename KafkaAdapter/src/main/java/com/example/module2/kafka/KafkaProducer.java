package com.example.module2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private static KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        KafkaProducer.kafkaTemplate = kafkaTemplate;
    }

    public static void sendMessage(String message) {
        LOGGER.info(String.format("Message was sent to HappyTopic successfully -> %s", message));
        kafkaTemplate.send("HappyTopic", message);
    }
}
