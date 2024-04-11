package org.example.payload;

public class JsonUrl {

        private String httpMethod;
        private String url;
        private String body;
        private String headers;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
