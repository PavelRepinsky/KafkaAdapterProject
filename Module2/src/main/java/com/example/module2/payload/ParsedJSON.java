package com.example.module2.payload;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Getter
@Setter
public class ParsedJSON {

    private String httpMethod;
    private String url;
    private HashMap<String, String> body;
    private HashMap<String, String> headers;
    private String parameters;

    @Override
    public String toString() {
        return "ParsedJSON{" +
                "httpMethod='" + httpMethod + '\'' +
                ", url='" + url + '\'' +
                ", body=" + body +
                ", headers=" + headers +
                ", parameters='" + parameters + '\'' +
                '}';
    }
}
