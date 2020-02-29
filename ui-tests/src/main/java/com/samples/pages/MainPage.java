package com.samples.pages;

import com.codeborne.selenide.Selenide;
import com.samples.components.LoginComponent;
import com.samples.components.RegisterComponent;
import com.samples.model.UserModel;
import io.qameta.allure.Step;

public class MainPage {

    private LoginComponent loginComponent = new LoginComponent();
    private RegisterComponent registerComponent = new RegisterComponent();

    @Step
    public static MainPage open() {
        Selenide.open("/");
        return new MainPage();
    }

    @Step
    public void loginAs(String username, String pass) {
        loginComponent.loginBtn().click();
        loginComponent.usernameField().sendKeys(username);
        loginComponent.passwordField().sendKeys(pass);
        loginComponent.submitBtn().click();
    }

    @Step
    public void registerAs(UserModel model) {
        registerComponent.registerBtn().click();
        registerComponent.usernameField().sendKeys(model.getUsername());
        registerComponent.emailField().sendKeys(model.getEmail());
        registerComponent.passwordField().sendKeys(model.getPassword());
        registerComponent.submitBtn().click();
    }
}
