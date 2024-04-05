package com.example.kafkaadapterproject.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Server {

    @GetMapping("/books")
    public String books(@RequestParam(name = "author") String author) {

        final Logger LOGGER = LoggerFactory.getLogger(Server.class);

        String books;
        if(author.equals("king")) {
        books = "It, Shining, Green Mile"; }
        else {
            books = "We have only King books";
        }

        LOGGER.info(String.format("Response was sended -> %s", books));
        return books;
    }
}
