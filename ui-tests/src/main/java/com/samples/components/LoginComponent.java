package com.samples.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginComponent {

    public SelenideElement loginBtn() {
        return $("#login");
    }

    public SelenideElement usernameField() {
        return $("#username-modal");
    }

    public SelenideElement passwordField() {
        return $("#password-modal");
    }

    public SelenideElement submitBtn() {
        return $("#login-modal p button");
    }

    public SelenideElement logoutButton() {
        return $("#logout > a");
    }
}
