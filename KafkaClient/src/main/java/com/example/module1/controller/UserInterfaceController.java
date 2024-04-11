package com.example.module1.controller;

import com.example.module1.kafka.JsonKafkaProducer;
import org.example.payload.JsonUrl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserInterfaceController {

    @GetMapping("/library")
    public String libraryForm(Model model) {
        model.addAttribute("library", new JsonUrl());
        return "library";
    }

    @PostMapping("/library")
    public String librarySubmit(@ModelAttribute JsonUrl jsonUrl, Model model) {
        model.addAttribute("library", jsonUrl);
        JsonKafkaProducer.sendMessage(jsonUrl);
        if (jsonUrl.getHttpMethod().equals("GET")) {
            return "result";
        }
        else {
            return  "libraryResponse";
        }
    }
}
