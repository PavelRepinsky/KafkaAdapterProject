package com.example.module2.payload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class Call {

    public static ParsedJSON parsedJSON;

    private static final Logger LOGGER = LoggerFactory.getLogger(Call.class);

    public static void formAndCallURL(ParsedJSON parsedJSON) throws URISyntaxException {
        HttpRequest.newBuilder()
                .uri(new URI(parsedJSON.getUrl() + parsedJSON.getParameters()))
                .headers(parsedJSON
                        .getHeaders()
                        .toString())
                .GET()
                .build();

        LOGGER.info("HTTP request was performed");
    }
}
