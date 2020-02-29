package com.samples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.getProperty;

public class BaseTest {

    final Faker faker = new Faker();

    @BeforeClass
    public static void setUp() {
        Map<String, String> myVars = new HashMap<>();
        myVars.put("env", getProperty("env", "stage"));
        String baseURI = ConfigFactory.create(ProjectConfig.class, myVars).apiPath();
        RestAssured.baseURI = baseURI;
        Configuration.baseUrl = baseURI;
//        Configuration.browser = "com.samples.utils.SelenoidWebDriverProvider";
        Configuration.browser = "chrome";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Step
    <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }
}
