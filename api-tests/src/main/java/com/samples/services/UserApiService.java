package com.samples.services;

import com.samples.assertions.AssertableResponse;
import com.samples.model.UserModel;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.samples.endpoint.Endpoints.*;

@Slf4j
public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(UserModel userModel) {
        return new AssertableResponse(setUp()
                .body(userModel)
                .when()
                .post(ENDPOINT_REGISTER));
    }

    @Step
    public AssertableResponse getAllUsers() {
        return new AssertableResponse(setUp()
                .when()
                .get(ENDPOINT_CUSTOMER));
    }

    @Step
    public AssertableResponse deleteUser(String id) {
        return new AssertableResponse(setUp()
                .pathParam("id", id)
                .when()
                .delete(ENDPOINT_CUSTOMERS_ID));
    }
}
