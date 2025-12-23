package com.id25.neondb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;


@SpringBootTest
@ActiveProfiles("test")
class DbAccessTest {


    @Test
    void envVarTest(){

        var foo = System.getenv("DATABASE_URL");

        Assert.hasText(foo, "");
    }
}