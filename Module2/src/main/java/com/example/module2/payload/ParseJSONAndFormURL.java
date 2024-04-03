package com.example.module2.payload;


import org.example.payload.JsonUrl;

public class ParseJSONAndFormURL {

    public ParsedJSON ParseJSON(JsonUrl JsonUrl) {
        ParsedJSON parsedJSON = new ParsedJSON();

        parsedJSON.setHttpMethod(JsonUrl.getHttpMethod());
        parsedJSON.setUrl(JsonUrl.getUrl());
        parsedJSON.setBody(JsonUrl.getBody());
        parsedJSON.setHeaders(JsonUrl.getHeaders());
        parsedJSON.setParameters(JsonUrl.getParameters());

        return parsedJSON;
    }
}
