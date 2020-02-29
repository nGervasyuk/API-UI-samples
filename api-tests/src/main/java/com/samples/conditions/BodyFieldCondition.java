package com.samples.conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;

@RequiredArgsConstructor
public class BodyFieldCondition implements Condition {

    private final String jsonPath;
    private final Matcher matcher;

    BodyFieldCondition(Matcher matcher) {
        this(null, matcher);
    }

    @Override
    public void check(Response response) {
        if (StringUtils.isAllBlank(jsonPath)) {
            response.then().assertThat().body(matcher);
        } else {
            response.then().assertThat().body(jsonPath, matcher);
        }
    }

    @Override
    public String toString() {
        if (StringUtils.isAllBlank(jsonPath)) {
            return "body field " + matcher;
        }
        return "body field [" + jsonPath + "] " + matcher;
    }
}
