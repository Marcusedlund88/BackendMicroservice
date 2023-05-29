package com.example.security.demo;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/demo-controller")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello World");
    }

}
