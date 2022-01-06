package com.example.testpipline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/users")
public class TestEndpoint {

    @GetMapping
    public String home() {
        return "Users working... OK. " + ZonedDateTime.now();
    }
}
