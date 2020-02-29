package com.samples;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    final Faker faker = new Faker();

    @BeforeAll
    public static void setUp() {
        Map myVars = new HashMap();
        myVars.put("env", System.getProperty("env", "stage"));

        RestAssured.baseURI = ConfigFactory.create(ProjectConfig.class, myVars).apiPath();
    }
}
