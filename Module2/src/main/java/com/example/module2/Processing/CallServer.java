package com.example.module2.Processing;

import com.example.module2.kafka.KafkaProducer;
import org.example.payload.JsonUrl;
import org.example.payload.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CallServer {

    public static int callResult;
    public static HttpClient httpClient = HttpClient.newHttpClient();

    private static final Logger LOGGER = LoggerFactory.getLogger(CallServer.class);


    public static void formAndCallURL(JsonUrl jsonUrl) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(jsonUrl.getUrl() + jsonUrl.getParameters()))
                .GET()
                .build();

        LOGGER.info("HTTP request was performed!");

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        callResult = response.statusCode();

        Message.message = response.body();

        KafkaProducer.sendMessage(Message.message);
    }
}
