package com.example.module1.kafka;

import com.example.module1.payload.JsonURL;
import org.example.payload.JsonUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, JsonURL> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, JsonURL> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(JsonUrl jsonUrl) {

        LOGGER.info(String.format("Message was sent to LuckyTopic successfully -> %s", jsonUrl.toString()));

        Message<JsonUrl> message = MessageBuilder
                .withPayload(jsonUrl)
                .setHeader(KafkaHeaders.TOPIC, "LuckyTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
