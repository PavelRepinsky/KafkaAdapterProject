package com.example.kafkaadapterproject.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class JsonURL {

    private String httpMethod;
    private String url;
    private HashMap<String, String> body;
    private HashMap<String, String> headers;
    private String parameters;

    @Override
    public String toString() {
        return "JsonURL{" +
                "httpMethod='" + httpMethod + '\'' +
                ", url='" + url + '\'' +
                ", body=" + body +
                ", headers=" + headers +
                ", parameters='" + parameters + '\'' +
                '}';
    }
}
