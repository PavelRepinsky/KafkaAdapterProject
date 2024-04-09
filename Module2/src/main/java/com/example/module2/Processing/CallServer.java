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
import java.util.Arrays;
import java.util.List;

public class CallServer {
    public static HttpClient httpClient = HttpClient.newHttpClient();

    private static final Logger LOGGER = LoggerFactory.getLogger(CallServer.class);


    public static void formAndCallURL(JsonUrl jsonUrl) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest.Builder requestBuilder;
        HttpRequest request;

        String headerString = jsonUrl.getHeaders();
        String[] headerLines = headerString.split(", ");

        if (jsonUrl.getHttpMethod().equals("GET")) {
            requestBuilder = HttpRequest.newBuilder()
                    .uri(new URI(jsonUrl.getUrl() + jsonUrl.getParameters()))
                    .GET();
        }
        else {
            requestBuilder = HttpRequest.newBuilder()
                    .uri(new URI(jsonUrl.getUrl() + jsonUrl.getParameters()))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonUrl.getBody()));
        }

        for (String headerLine : headerLines) {
            String[] headerParts = headerLine.split(": ");
            if (headerParts.length == 2) {
                requestBuilder.header(headerParts[0], headerParts[1]);
            }
        }

        request = requestBuilder.build();

        LOGGER.info("HTTP request was performed!");

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(request.headers());
        System.out.println("Response code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        Message.message = response.body();

        KafkaProducer.sendMessage(Message.message);
    }
}
