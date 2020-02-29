package com.samples.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPage {

    @Step
    public SelenideElement logoutButton() {
        return $("#logout > a");
    }
}
