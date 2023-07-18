package com.istio.demo.userdataservice.controller;

import com.istio.demo.userdataservice.model.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserDataController {

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/ docker run -d --network my_network --name Container1 user-auth-service:latest\n/{username}")
    public ResponseEntity<UserData> getUserData(@PathVariable String username) {
        log.info("Request: username:"+username);
        if ("user1".equals(username)) {
            UserData userData = UserData.builder().name("John Doe").age(30).build();
            log.info("Request: userData:"+userData.toString());
            return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

