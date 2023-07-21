package com.istio.demo.userdataservice.controller;

import com.istio.demo.userdataservice.model.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserDataController {

    @GetMapping("/user_data/{username}")
    public ResponseEntity<UserData> getUserData(@PathVariable String username) {

        if ("user1".equals(username)) {
            UserData userData = UserData.builder().name("Adam Smith").age(48).build();
            log.info("Request: userData:"+userData.toString());
            return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

