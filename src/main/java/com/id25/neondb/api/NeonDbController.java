package com.id25.neondb.api;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NeonDbController {

    private final String databaseUrl;

    public NeonDbController(Environment env) {
        this.databaseUrl = env.getProperty("DATABASE_USER");
    }

    @GetMapping("/url")
    public String getUrl() {
        return databaseUrl;
    }

    @GetMapping("/health")
    public String getHealth() {
        return "ok";
    }
}
