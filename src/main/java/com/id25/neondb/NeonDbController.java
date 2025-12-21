package com.id25.neondb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NeonDbController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
