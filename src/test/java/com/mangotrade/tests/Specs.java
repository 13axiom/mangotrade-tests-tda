package com.mangotrade.tests;

import com.codeborne.selenide.Configuration;
import com.mangotrade.config.Project;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.mangotrade.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class Specs {


    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri(Project.config.restUrl())
            .cookie("platform=90; " +
                    "lang=en_US; " +
                    "ssid=054fa7be0f836899ee76da4c7aca8bb8")
            .header("Connection", "keep-alive")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("code", is("success"))
            .expectBody("ssid", is(notNullValue()))
            .build();

    public static ResponseSpecification failedResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(401)
            .expectBody("code", is("invalid_credentials"))
            .expectBody("message", is("You entered the wrong credentials. " +
                    "Please ensure that your login/password is correct."))
            .build();
}
