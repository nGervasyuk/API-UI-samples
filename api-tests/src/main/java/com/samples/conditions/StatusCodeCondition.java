package com.samples.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StatusCodeCondition implements Condition {

    private final Integer expectedStatusCode;

    @Override
    public void check(Response response) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    @Override
    public String toString() {
        return "status code " + expectedStatusCode;
    }
}
