package com.example.module1.controller;

import com.example.module1.kafka.JsonKafkaProducer;
import org.example.payload.JsonUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publishjson")
    public ResponseEntity<String> publishjson(@RequestBody JsonUrl JsonUrl) {
        kafkaProducer.sendMessage(JsonUrl);
        return ResponseEntity.ok("JSON message was sent to LuckyTopic successfully");
    }

}
