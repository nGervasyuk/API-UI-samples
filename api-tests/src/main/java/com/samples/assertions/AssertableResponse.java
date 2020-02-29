package com.samples.assertions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samples.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    private final Response response;

    @Step("Response should have: {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("Check condition: " + condition);
        condition.check(response);
        return this;
    }

    public <T> T getValue(String jsonPath, Class<T> tClass) {
        return response.jsonPath().getObject(jsonPath, tClass);
    }

    public <T> T asPojo(Class<T> tClass) {
        String inputStream = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputStream, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String jsonPath) {
        return response.jsonPath().getObject(jsonPath, String.class);
    }
}
