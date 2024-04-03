package org.example.payload;

import java.util.HashMap;

public class JsonUrl {

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

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getBody() {
        return body;
    }

    public void setBody(HashMap<String, String> body) {
        this.body = body;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
