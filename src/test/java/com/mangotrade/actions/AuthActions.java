package com.mangotrade.actions;

import com.mangotrade.config.Project;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import models.LoginData;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.Matchers.is;


import static com.mangotrade.tests.Specs.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthActions {

    @Step("Authorization")
    public void authorization() {
        LoginData data = new LoginData();
        data.setIdentifier(Project.userData.userLogin());
        data.setPassword(Project.userData.userPassword());

        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/v2/login")
                .then()
                .spec(successResponseSpec);


    }

    @Step("Get authorization cookie")
    public String getAuthorizationCookie() {
        LoginData data = new LoginData();
        data.setIdentifier(Project.userData.userLogin());
        data.setPassword(Project.userData.userPassword());

        String authorizationCookie =
                given()
                        .spec(request)
                        .body(data)
                        .when()
                        .post("/api/v2/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .cookie("ssid");
        return authorizationCookie;
    }

}
