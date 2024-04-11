package com.example.kafkaadapterproject.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Server {

    final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    @GetMapping("/books")
    public String books(@RequestParam(name = "author") String author) {


        String books;
        if(author.equals("king")) {
        books = "It, Shining, Green Mile"; }
        else if (author.equals("orwell")) {
            books = "1984, Animal Farm, Coming Up for Air";
        }
        else if (author.equals("pushkin")) {
            books = "Eugene Onegin, The Captain’s Daughter, Boris Godunov";
        }
        else if (author.equals("dostoevsky")) {
            books = "Crime and Punishment, The Brothers Karamazov, The Idiot";
        }
        else if (author.equals("bradbury")) {
            books = "Fahrenheit 451, Dandelion Wine, The Homecoming";
        }
        else {
            books = "Sorry, we do not have books written by this author";
        }

        LOGGER.info(String.format("Response was sent -> %s", books));
        return books;
    }

    @PostMapping("/books")
    public ResponseEntity<String> sayThanks() {
        String response;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        response = "Thank You very much! Village Library does appreciate it!";

        LOGGER.info(String.format("Response was sent -> %s", response));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}
