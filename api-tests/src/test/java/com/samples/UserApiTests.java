package com.samples;

import com.samples.model.UserModel;
import com.samples.responses.user.UserListResponse;
import com.samples.services.UserApiService;
import org.junit.jupiter.api.Test;

import static com.samples.conditions.Conditions.bodyField;
import static com.samples.conditions.Conditions.statusCode;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

class UserApiTests extends BaseTest {

    private final UserApiService userApiService = new UserApiService();

    @Test
    void testCanRegisterAndGetUser() {
        UserModel userModel = new UserModel()
                .setUsername(faker.name().username())
                .setPassword(faker.internet().password())
                .setEmail(faker.internet().emailAddress());

        userApiService.registerUser(userModel)
                .shouldHave(statusCode(SC_OK))
                .shouldHave(bodyField("id", not(isEmptyString())));

        UserListResponse users = userApiService.getAllUsers().asPojo(UserListResponse.class);
        assertThat(users.getEmbedded().getCustomer().size()).isGreaterThan(1);
    }

    @Test
    void testCanDeleteUser() {
        UserModel userModel = new UserModel()
                .setUsername(faker.name().username())
                .setPassword(faker.internet().password())
                .setEmail(faker.internet().emailAddress());

        String id = userApiService.registerUser(userModel)
                .shouldHave(statusCode(SC_OK))
                .shouldHave(bodyField("id", not(isEmptyString())))
                .getValue("id");

        userApiService.deleteUser(id)
                .shouldHave(statusCode(SC_OK));
    }
}
