package com.example.testpipline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TestEndpoint {

    @GetMapping
    public String home() {
        return "Users working... OK";
    }
}
