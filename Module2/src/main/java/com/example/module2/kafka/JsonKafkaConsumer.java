package com.example.module2.kafka;

import com.example.module2.payload.Call;
import com.example.module2.payload.ParseJSONAndFormURL;
import org.example.payload.JsonUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "LuckyTopic", groupId = "firstGroup")
    public void consume(JsonUrl jsonUrl) throws URISyntaxException {
        LOGGER.info(String.format("JSON message was received -> %s", jsonUrl.toString()));

        ParseJSONAndFormURL parseJSONAndFormURL = new ParseJSONAndFormURL();
        Call.parsedJSON = parseJSONAndFormURL.ParseJSON(jsonUrl);
        Call.formAndCallURL(Call.parsedJSON);
    }
}
