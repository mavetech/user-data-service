package com.istio.demo.userdataservice.controller;

import com.istio.demo.userdataservice.model.UserData;
import com.istio.demo.userdataservice.util.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class UserDataController {

    @GetMapping("/user_data/{username}")
    public ResponseEntity<Object> getUserData(@PathVariable String username) {
        // Generate a random number between 0 and 1 (inclusive)
        int random = new Random().nextInt(2);

        if (random == 0) {
            UserData userData = UserData.builder().name("David Smith").age(48).build();
            log.info("Request: userData: {}", userData.toString());
            return ResponseEntity.ok(userData);
        } else {
            String message = "Service Unavailable";
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            ErrorResponse errorResponse = new ErrorResponse(message, headers, HttpStatus.SERVICE_UNAVAILABLE);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
        }
    }
}

