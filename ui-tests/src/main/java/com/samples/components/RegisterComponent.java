package com.samples.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegisterComponent {

    public SelenideElement registerBtn() {
        return $("#register");
    }

    public SelenideElement usernameField() {
        return $("#register-username-modal");
    }

    public SelenideElement emailField() {
        return $("#register-email-modal");
    }

    public SelenideElement passwordField() {
        return $("#register-password-modal");
    }

    public SelenideElement submitBtn() {
        return $("#register-modal p button");
    }
}
