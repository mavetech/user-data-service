package com.istio.demo.userdataservice.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private MultiValueMap<String, String> headers;
    private HttpStatus status;

    public ErrorResponse(String message, MultiValueMap<String, String> headers, HttpStatus status) {
        this.message = message;
        this.headers = headers;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public MultiValueMap<String, String> getHeaders() {
        return headers;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ResponseEntity<Object> toResponseEntity() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("message", message);

        String responseBody;
        try {
            responseBody = objectMapper.writeValueAsString(errorBody);
        } catch (Exception e) {
            responseBody = "{\"message\":\"Error generating JSON response\"}";
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(responseBody, responseHeaders, status);
    }
}
