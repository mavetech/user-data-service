package com.istio.demo.userdataservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserData {
    private String name;
    private int age;

    // Constructors, getters, and setters (omitted for brevity).
}

