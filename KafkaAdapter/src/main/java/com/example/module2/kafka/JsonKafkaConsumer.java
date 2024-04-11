package com.example.module2.kafka;
import com.example.module2.Processing.CallServer;
import org.example.payload.JsonUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class JsonKafkaConsumer {

    public static JsonUrl receivedJsonUrl;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "LuckyTopic", groupId = "firstGroup")
    public void consume(JsonUrl jsonUrl) throws URISyntaxException, IOException, InterruptedException {
        LOGGER.info(String.format("JSON message was received -> %s", jsonUrl.toString()));

        receivedJsonUrl = jsonUrl;
        CallServer.processJsonUrl();
    }
}
