package com.samples;

import com.samples.model.UserModel;
import com.samples.pages.LoggedUserPage;
import com.samples.pages.MainPage;
import com.samples.services.UserApiService;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class LoginTest extends BaseTest {

    private UserModel userModel = new UserModel();

    @Test
    public void userCanLoginWithValidCredential() {
        createUserByApiCall();
        MainPage.open()
                .loginAs(userModel.getUsername(), userModel.getPassword());
        at(LoggedUserPage.class)
                .logoutButton().shouldHave(text("Logout"));
    }

    @Test
    public void userCanRegisterWithValidCredential() {
        MainPage.open()
                .registerAs(userData());
        at(LoggedUserPage.class)
                .logoutButton().shouldHave(text("Logout"));
    }

    private void createUserByApiCall() {
        UserApiService userApiService = new UserApiService();
        userApiService.registerUser(userData());
    }

    private UserModel userData() {
        return userModel = new UserModel()
                .setUsername(faker.name().username())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password());
    }
}
